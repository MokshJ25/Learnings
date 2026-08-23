import { useState, useMemo, useCallback, useRef, useEffect } from "react";
import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Label } from "@/components/ui/label";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { Checkbox } from "@/components/ui/checkbox";
import { toast } from "sonner";
import { Plus, Trash2, Receipt, Calculator, X } from "lucide-react";
import { format } from "date-fns";
import type { Database } from "@/integrations/supabase/types";

type Item = Database["public"]["Tables"]["items"]["Row"];

interface BillLineItem {
  id: string;
  item_id: string | null;
  item_name: string;
  variant: string;
  selling_type: "per_piece" | "per_weight";
  quantity: number;
  weight: number;
  price: number;
  total: number;
}

let lineIdCounter = 0;
const newLine = (): BillLineItem => ({
  id: `line-${++lineIdCounter}`,
  item_id: null,
  item_name: "",
  variant: "",
  selling_type: "per_piece",
  quantity: 1,
  weight: 0,
  price: 0,
  total: 0,
});

// Safe calculator: only allows numbers, operators, and decimal
function safeEval(expr: string): string {
  try {
    const sanitized = expr.replace(/[^0-9+\-*/.()]/g, "");
    if (!sanitized) return "0";
    const result = Function(`"use strict"; return (${sanitized})`)();
    if (typeof result !== "number" || !isFinite(result)) return "Error";
    return String(Math.round(result * 100) / 100);
  } catch {
    return "Error";
  }
}

export default function BillingPage() {
  const queryClient = useQueryClient();
  const [customerName, setCustomerName] = useState("");
  const [village, setVillage] = useState("");
  const [billDate, setBillDate] = useState(format(new Date(), "yyyy-MM-dd"));
  const [lines, setLines] = useState<BillLineItem[]>([newLine()]);
  const [discount, setDiscount] = useState(0);
  const [payLater, setPayLater] = useState(false);
  const [fullPayLater, setFullPayLater] = useState(false);
  const [partialPayLater, setPartialPayLater] = useState(0);
  const [amountPaid, setAmountPaid] = useState(0);
  const [asTotal, setAsTotal] = useState(false);
  const [itemSearch, setItemSearch] = useState<Record<string, string>>({});
  const [activeSearchLine, setActiveSearchLine] = useState<string | null>(null);
  const [showCalc, setShowCalc] = useState(false);
  const [calcDisplay, setCalcDisplay] = useState("0");

  const { data: items } = useQuery({
    queryKey: ["all-items"],
    queryFn: async () => {
      const { data } = await supabase.from("items").select("*").order("item_name");
      return data || [];
    },
    staleTime: 30000,
  });

  const { data: metalPrices } = useQuery({
    queryKey: ["metal-prices"],
    queryFn: async () => {
      const { data } = await supabase.from("metal_prices").select("*").order("metal_type");
      return data || [];
    },
    staleTime: 60000,
  });

  const subtotal = useMemo(() => lines.reduce((s, l) => s + l.total, 0), [lines]);
  const finalTotal = Math.max(0, subtotal - discount);

  const effectiveAmountPaid = asTotal ? finalTotal : amountPaid;
  const dueAmount = payLater
    ? fullPayLater
      ? finalTotal
      : Math.min(partialPayLater, finalTotal)
    : Math.max(0, finalTotal - effectiveAmountPaid);

  const updateLine = useCallback((id: string, updates: Partial<BillLineItem>) => {
    setLines((prev) =>
      prev.map((l) => {
        if (l.id !== id) return l;
        const updated = { ...l, ...updates };
        if (updated.selling_type === "per_piece") {
          updated.total = updated.quantity * updated.price;
        } else {
          updated.total = updated.weight * updated.price;
        }
        return updated;
      })
    );
  }, []);

  const selectItem = useCallback((lineId: string, item: Item) => {
    updateLine(lineId, {
      item_id: item.id,
      item_name: item.item_name,
      variant: item.variant,
      selling_type: item.selling_type,
      price: item.selling_type === "per_piece" ? item.price : item.price_per_kg,
      quantity: 1,
      weight: 0,
    });
    setItemSearch((prev) => ({ ...prev, [lineId]: "" }));
    setActiveSearchLine(null);
  }, [updateLine]);

  const getFilteredItems = useCallback((lineId: string) => {
    const q = (itemSearch[lineId] || "").toLowerCase();
    if (!q) return [];
    return (items || []).filter(
      (i) =>
        i.item_name.toLowerCase().includes(q) ||
        i.company.toLowerCase().includes(q) ||
        i.variant.toLowerCase().includes(q)
    ).slice(0, 8);
  }, [items, itemSearch]);

  const resetForm = useCallback(() => {
    setCustomerName("");
    setVillage("");
    setBillDate(format(new Date(), "yyyy-MM-dd"));
    setLines([newLine()]);
    setDiscount(0);
    setPayLater(false);
    setFullPayLater(false);
    setPartialPayLater(0);
    setAmountPaid(0);
    setAsTotal(false);
    setItemSearch({});
    setActiveSearchLine(null);
  }, []);

  const saveBillMutation = useMutation({
    mutationFn: async () => {
      if (!customerName.trim()) throw new Error("Customer name is required");
      const validLines = lines.filter((l) => l.item_name && l.total > 0);
      if (validLines.length === 0) throw new Error("Add at least one item with a total > 0");

      const paid = payLater
        ? fullPayLater
          ? 0
          : Math.max(0, finalTotal - partialPayLater)
        : effectiveAmountPaid;

      const due = Math.max(0, finalTotal - paid);
      const status = due <= 0 ? "paid" : paid > 0 ? "partial" : "pending";

      // Create bill
      const { data: bill, error: billError } = await supabase
        .from("bills")
        .insert({
          customer_name: customerName.trim(),
          village: village.trim(),
          bill_date: billDate,
          subtotal,
          discount,
          total: finalTotal,
          amount_paid: Math.max(0, paid),
          due_amount: due,
          status,
        })
        .select()
        .single();
      if (billError) throw billError;

      // Create bill items
      const billItems = validLines.map((l) => ({
        bill_id: bill.id,
        item_id: l.item_id,
        item_name: l.item_name,
        variant: l.variant,
        selling_type: l.selling_type,
        quantity: l.quantity,
        weight: l.weight,
        price: l.price,
        total: l.total,
      }));
      const { error: itemsError } = await supabase.from("bill_items").insert(billItems);
      if (itemsError) throw itemsError;

      // Deduct stock for per_piece items
      for (const line of validLines) {
        if (line.item_id && line.selling_type === "per_piece" && line.quantity > 0) {
          const item = items?.find((i) => i.id === line.item_id);
          if (item) {
            await supabase
              .from("items")
              .update({ quantity: Math.max(0, item.quantity - line.quantity) })
              .eq("id", line.item_id);
          }
        }
      }

      // Upsert customer
      const { data: existingCustomer } = await supabase
        .from("customers")
        .select("*")
        .eq("name", customerName.trim())
        .maybeSingle();

      if (existingCustomer) {
        await supabase
          .from("customers")
          .update({
            village: village.trim(),
            total_due: Number(existingCustomer.total_due) + due,
          })
          .eq("id", existingCustomer.id);
      } else {
        await supabase.from("customers").insert({
          name: customerName.trim(),
          village: village.trim(),
          total_due: due,
        });
      }

      // Record payment
      if (paid > 0) {
        await supabase.from("payments").insert({
          bill_id: bill.id,
          amount: paid,
          notes: "Initial payment",
        });
      }

      return bill;
    },
    onSuccess: (bill) => {
      queryClient.invalidateQueries();
      toast.success(`Bill #${bill.bill_number} created successfully!`);
      resetForm();
    },
    onError: (e) => toast.error(e.message),
  });

  // Calculator
  const calcPress = (val: string) => {
    if (val === "C") { setCalcDisplay("0"); return; }
    if (val === "⌫") { setCalcDisplay((prev) => prev.length > 1 ? prev.slice(0, -1) : "0"); return; }
    if (val === "=") { setCalcDisplay(safeEval(calcDisplay)); return; }
    setCalcDisplay((prev) => prev === "0" && val !== "." ? val : prev + val);
  };

  return (
    <div className="space-y-4 max-w-7xl">
      <div className="flex items-center justify-between">
        <p className="text-muted-foreground text-sm">Create a new bill</p>
        <Button variant="outline" size="sm" onClick={() => setShowCalc(!showCalc)}>
          <Calculator className="w-4 h-4 mr-1.5" />
          {showCalc ? "Hide" : "Calculator"}
        </Button>
      </div>

      {showCalc && (
        <Card className="shadow-surface-lg max-w-[280px] animate-fade-in">
          <CardContent className="p-3">
            <div className="bg-muted rounded-lg p-3 text-right text-xl font-heading font-bold mb-2 min-h-[44px] break-all">
              {calcDisplay}
            </div>
            <div className="grid grid-cols-4 gap-1.5">
              {["7","8","9","÷","4","5","6","×","1","2","3","-","0",".","=","+"].map((b) => {
                const val = b === "÷" ? "/" : b === "×" ? "*" : b;
                return (
                  <Button key={b} variant={b === "=" ? "default" : "outline"} size="sm" onClick={() => calcPress(val)}>
                    {b}
                  </Button>
                );
              })}
              <Button variant="outline" size="sm" onClick={() => calcPress("⌫")}>⌫</Button>
              <Button variant="destructive" size="sm" className="col-span-3" onClick={() => calcPress("C")}>
                Clear
              </Button>
            </div>
          </CardContent>
        </Card>
      )}

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-4">
        {/* Customer info */}
        <Card className="shadow-surface lg:col-span-3">
          <CardContent className="pt-6">
            <div className="grid grid-cols-1 sm:grid-cols-3 gap-4">
              <div className="space-y-1.5">
                <Label className="text-sm font-medium">Customer Name *</Label>
                <Input value={customerName} onChange={(e) => setCustomerName(e.target.value)} placeholder="Customer name" />
              </div>
              <div className="space-y-1.5">
                <Label className="text-sm font-medium">Village</Label>
                <Input value={village} onChange={(e) => setVillage(e.target.value)} placeholder="Village" />
              </div>
              <div className="space-y-1.5">
                <Label className="text-sm font-medium">Date</Label>
                <Input type="date" value={billDate} onChange={(e) => setBillDate(e.target.value)} />
              </div>
            </div>
          </CardContent>
        </Card>

        {/* Items */}
        <Card className="shadow-surface lg:col-span-2">
          <CardHeader className="pb-3">
            <div className="flex items-center justify-between">
              <CardTitle className="text-base">Items ({lines.length})</CardTitle>
              <Button size="sm" variant="outline" onClick={() => setLines([...lines, newLine()])}>
                <Plus className="w-3 h-3 mr-1" /> Add Row
              </Button>
            </div>
          </CardHeader>
          <CardContent className="space-y-3">
            {lines.map((line, idx) => (
              <div key={line.id} className="border border-border rounded-lg p-3 space-y-3 hover:border-primary/20 transition-colors">
                <div className="flex items-center justify-between">
                  <span className="text-xs font-semibold text-muted-foreground">Item #{idx + 1}</span>
                  {lines.length > 1 && (
                    <Button variant="ghost" size="icon" className="h-6 w-6" onClick={() => setLines(lines.filter((l) => l.id !== line.id))}>
                      <Trash2 className="w-3 h-3 text-destructive" />
                    </Button>
                  )}
                </div>

                <div className="relative">
                  <Input
                    placeholder="Search item by name, brand, or variant..."
                    value={activeSearchLine === line.id ? (itemSearch[line.id] || "") : (line.item_name || itemSearch[line.id] || "")}
                    onFocus={() => setActiveSearchLine(line.id)}
                    onBlur={() => setTimeout(() => setActiveSearchLine(null), 200)}
                    onChange={(e) => {
                      setItemSearch({ ...itemSearch, [line.id]: e.target.value });
                      setActiveSearchLine(line.id);
                      if (!e.target.value) updateLine(line.id, { item_id: null, item_name: "", variant: "", price: 0, total: 0 });
                    }}
                  />
                  {line.item_name && activeSearchLine !== line.id && (
                    <button
                      className="absolute right-2 top-1/2 -translate-y-1/2 text-muted-foreground hover:text-foreground"
                      onClick={() => {
                        updateLine(line.id, { item_id: null, item_name: "", variant: "", price: 0, total: 0 });
                        setItemSearch({ ...itemSearch, [line.id]: "" });
                      }}
                    >
                      <X className="w-3.5 h-3.5" />
                    </button>
                  )}
                  {activeSearchLine === line.id && (itemSearch[line.id] || "").length > 0 && (
                    <div className="absolute z-20 top-full left-0 right-0 bg-card border border-border rounded-lg mt-1 shadow-lg max-h-48 overflow-y-auto">
                      {getFilteredItems(line.id).map((item) => (
                        <button
                          key={item.id}
                          className="w-full text-left px-3 py-2.5 hover:bg-muted/50 text-sm flex justify-between gap-2 border-b border-border/30 last:border-0"
                          onMouseDown={(e) => e.preventDefault()}
                          onClick={() => selectItem(line.id, item)}
                        >
                          <span className="font-medium truncate">
                            {item.item_name}
                            {item.variant && <span className="text-muted-foreground font-normal"> ({item.variant})</span>}
                          </span>
                          <span className="text-muted-foreground text-xs whitespace-nowrap">
                            {item.company} • {item.selling_type === "per_piece" ? `₹${item.price}` : `₹${item.price_per_kg}/kg`}
                          </span>
                        </button>
                      ))}
                      {getFilteredItems(line.id).length === 0 && (
                        <div className="px-3 py-3 text-sm text-muted-foreground text-center">No items found</div>
                      )}
                    </div>
                  )}
                </div>

                {line.item_name && (
                  <div className="grid grid-cols-2 sm:grid-cols-4 gap-3">
                    <div className="space-y-1">
                      <Label className="text-xs text-muted-foreground">Type</Label>
                      <div className="text-sm font-medium h-8 flex items-center">
                        <span className={`inline-flex items-center px-2 py-0.5 rounded-full text-xs font-medium ${
                          line.selling_type === "per_piece" ? "bg-primary/10 text-primary" : "bg-accent text-accent-foreground"
                        }`}>
                          {line.selling_type === "per_piece" ? "Per Piece" : "Per Weight"}
                        </span>
                      </div>
                    </div>

                    {line.selling_type === "per_piece" ? (
                      <div className="space-y-1">
                        <Label className="text-xs text-muted-foreground">Qty</Label>
                        <Input type="number" min="1" className="h-8 text-sm" value={line.quantity} onChange={(e) => updateLine(line.id, { quantity: Math.max(1, parseInt(e.target.value) || 1) })} />
                      </div>
                    ) : (
                      <div className="space-y-1">
                        <Label className="text-xs text-muted-foreground">Weight (kg)</Label>
                        <Input type="number" step="0.001" min="0" className="h-8 text-sm" value={line.weight || ""} onChange={(e) => updateLine(line.id, { weight: parseFloat(e.target.value) || 0 })} />
                      </div>
                    )}

                    <div className="space-y-1">
                      <Label className="text-xs text-muted-foreground">Price {line.selling_type === "per_weight" ? "/kg" : ""}</Label>
                      {line.selling_type === "per_weight" ? (
                        <Select value={String(line.price)} onValueChange={(v) => updateLine(line.id, { price: parseFloat(v) })}>
                          <SelectTrigger className="h-8 text-sm"><SelectValue placeholder="Rate" /></SelectTrigger>
                          <SelectContent>
                            {line.price > 0 && <SelectItem value={String(line.price)}>₹{line.price}/kg (default)</SelectItem>}
                            {metalPrices?.map((mp) => (
                              <SelectItem key={mp.id} value={String(mp.price_per_kg)}>
                                {mp.metal_type} - {mp.company || "General"} (₹{mp.price_per_kg}/kg)
                              </SelectItem>
                            ))}
                          </SelectContent>
                        </Select>
                      ) : (
                        <Input type="number" step="0.01" min="0" className="h-8 text-sm" value={line.price} onChange={(e) => updateLine(line.id, { price: parseFloat(e.target.value) || 0 })} />
                      )}
                    </div>

                    <div className="space-y-1">
                      <Label className="text-xs text-muted-foreground">Total</Label>
                      <div className="text-sm font-bold h-8 flex items-center text-primary">
                        ₹{line.total.toLocaleString("en-IN", { minimumFractionDigits: 2 })}
                      </div>
                    </div>
                  </div>
                )}
              </div>
            ))}
          </CardContent>
        </Card>

        {/* Payment summary */}
        <Card className="shadow-surface lg:sticky lg:top-20 lg:self-start">
          <CardHeader className="pb-3">
            <CardTitle className="text-base">Payment Summary</CardTitle>
          </CardHeader>
          <CardContent className="space-y-4">
            <div className="flex justify-between text-sm">
              <span className="text-muted-foreground">Subtotal ({lines.filter(l => l.item_name).length} items)</span>
              <span className="font-semibold">₹{subtotal.toLocaleString("en-IN", { minimumFractionDigits: 2 })}</span>
            </div>

            <div className="space-y-1.5">
              <Label className="text-sm">Discount (₹)</Label>
              <Input type="number" step="0.01" min="0" value={discount || ""} onChange={(e) => setDiscount(parseFloat(e.target.value) || 0)} placeholder="0.00" />
            </div>

            <div className="flex justify-between items-center border-t border-border pt-3">
              <span className="font-heading font-semibold">Total</span>
              <span className="font-heading font-bold text-xl text-primary">
                ₹{finalTotal.toLocaleString("en-IN", { minimumFractionDigits: 2 })}
              </span>
            </div>

            <div className="space-y-3 border-t border-border pt-3">
              <div className="flex items-center gap-2">
                <Checkbox id="payLater" checked={payLater} onCheckedChange={(c) => { setPayLater(!!c); if (!c) { setFullPayLater(false); setPartialPayLater(0); } }} />
                <Label htmlFor="payLater" className="text-sm cursor-pointer">Pay Later</Label>
              </div>

              {payLater ? (
                <div className="pl-6 space-y-3 animate-fade-in">
                  <div className="flex items-center gap-2">
                    <Checkbox id="fullPayLater" checked={fullPayLater} onCheckedChange={(c) => setFullPayLater(!!c)} />
                    <Label htmlFor="fullPayLater" className="text-sm cursor-pointer">Full Amount</Label>
                  </div>
                  {!fullPayLater && (
                    <div className="space-y-1">
                      <Label className="text-xs">Pay Later Amount (₹)</Label>
                      <Input type="number" step="0.01" min="0" value={partialPayLater || ""} onChange={(e) => setPartialPayLater(parseFloat(e.target.value) || 0)} placeholder="0.00" />
                    </div>
                  )}
                </div>
              ) : (
                <div className="space-y-3 animate-fade-in">
                  <div className="flex items-center gap-2">
                    <Checkbox id="asTotal" checked={asTotal} onCheckedChange={(c) => { setAsTotal(!!c); if (c) setAmountPaid(finalTotal); }} />
                    <Label htmlFor="asTotal" className="text-sm cursor-pointer">Paid Full Amount</Label>
                  </div>
                  {!asTotal && (
                    <div className="space-y-1">
                      <Label className="text-xs">Amount Paid (₹)</Label>
                      <Input type="number" step="0.01" min="0" value={amountPaid || ""} onChange={(e) => setAmountPaid(parseFloat(e.target.value) || 0)} placeholder="0.00" />
                    </div>
                  )}
                </div>
              )}
            </div>

            <div className="flex justify-between text-sm border-t border-border pt-3">
              <span className="text-muted-foreground">Due Amount</span>
              <span className={`font-bold ${dueAmount > 0 ? "text-destructive" : "text-success"}`}>
                ₹{dueAmount.toLocaleString("en-IN", { minimumFractionDigits: 2 })}
              </span>
            </div>

            <Button className="w-full" size="lg" onClick={() => saveBillMutation.mutate()} disabled={saveBillMutation.isPending || !customerName.trim()}>
              <Receipt className="w-4 h-4 mr-2" />
              {saveBillMutation.isPending ? "Generating..." : "Generate Bill"}
            </Button>
          </CardContent>
        </Card>
      </div>
    </div>
  );
}
