import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { Card, CardContent } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Dialog, DialogContent, DialogHeader, DialogTitle } from "@/components/ui/dialog";
import { Label } from "@/components/ui/label";
import { Skeleton } from "@/components/ui/skeleton";
import { toast } from "sonner";
import { useState } from "react";
import { CreditCard, Search } from "lucide-react";

export default function PaymentsPage() {
  const queryClient = useQueryClient();
  const [payDialog, setPayDialog] = useState<{ billId: string; due: number } | null>(null);
  const [payAmount, setPayAmount] = useState(0);
  const [search, setSearch] = useState("");

  const { data: pendingBills, isLoading } = useQuery({
    queryKey: ["pending-bills"],
    queryFn: async () => {
      const { data, error } = await supabase
        .from("bills")
        .select("*")
        .gt("due_amount", 0)
        .order("created_at", { ascending: false });
      if (error) throw error;
      return data;
    },
  });

  const filteredBills = pendingBills?.filter((b) =>
    !search || b.customer_name.toLowerCase().includes(search.toLowerCase()) || b.village.toLowerCase().includes(search.toLowerCase())
  );

  const totalPendingDues = pendingBills?.reduce((s, b) => s + Number(b.due_amount), 0) || 0;

  const payMutation = useMutation({
    mutationFn: async () => {
      if (!payDialog || payAmount <= 0) throw new Error("Enter a valid amount");
      const bill = pendingBills?.find((b) => b.id === payDialog.billId);
      if (!bill) throw new Error("Bill not found");

      const newPaid = Number(bill.amount_paid) + payAmount;
      // bill.total already has discount applied
      const newDue = Math.max(0, Number(bill.total) - newPaid);
      const status = newDue <= 0 ? "paid" : "partial";

      const { error: billError } = await supabase
        .from("bills")
        .update({ amount_paid: newPaid, due_amount: newDue, status })
        .eq("id", payDialog.billId);
      if (billError) throw billError;

      const { error: payError } = await supabase
        .from("payments")
        .insert({ bill_id: payDialog.billId, amount: payAmount, notes: "Payment received" });
      if (payError) throw payError;

      // Update customer due
      const { data: customer } = await supabase
        .from("customers")
        .select("*")
        .eq("name", bill.customer_name)
        .maybeSingle();
      if (customer) {
        await supabase
          .from("customers")
          .update({ total_due: Math.max(0, Number(customer.total_due) - payAmount) })
          .eq("id", customer.id);
      }
    },
    onSuccess: () => {
      queryClient.invalidateQueries();
      toast.success("Payment recorded successfully");
      setPayDialog(null);
      setPayAmount(0);
    },
    onError: (e) => toast.error(e.message),
  });

  return (
    <div className="space-y-4 max-w-7xl">
      <div className="flex flex-col sm:flex-row gap-3 items-start sm:items-center justify-between">
        <div>
          <p className="text-muted-foreground text-sm">Bills with pending payments</p>
          {totalPendingDues > 0 && (
            <p className="text-xs text-destructive font-medium mt-0.5">
              Total pending: ₹{totalPendingDues.toLocaleString("en-IN", { minimumFractionDigits: 2 })}
            </p>
          )}
        </div>
        <div className="relative max-w-sm w-full sm:w-auto">
          <Search className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-muted-foreground" />
          <Input placeholder="Search by customer..." value={search} onChange={(e) => setSearch(e.target.value)} className="pl-9" />
        </div>
      </div>

      <Dialog open={!!payDialog} onOpenChange={(open) => { if (!open) { setPayDialog(null); setPayAmount(0); } }}>
        <DialogContent>
          <DialogHeader><DialogTitle>Record Payment</DialogTitle></DialogHeader>
          <div className="space-y-4">
            <div className="bg-muted/50 rounded-lg p-3 flex justify-between items-center">
              <span className="text-sm text-muted-foreground">Due Amount</span>
              <span className="font-heading font-bold text-destructive">₹{payDialog?.due.toLocaleString("en-IN", { minimumFractionDigits: 2 })}</span>
            </div>
            <div className="space-y-1.5">
              <Label>Payment Amount (₹)</Label>
              <Input
                type="number"
                step="0.01"
                min="0"
                max={payDialog?.due}
                value={payAmount || ""}
                onChange={(e) => setPayAmount(Math.min(parseFloat(e.target.value) || 0, payDialog?.due || 0))}
                placeholder="Enter amount"
                autoFocus
              />
            </div>
            <div className="flex gap-2">
              <Button variant="outline" className="flex-1" onClick={() => setPayAmount(payDialog?.due || 0)}>
                Pay Full Amount
              </Button>
              <Button className="flex-1" onClick={() => payMutation.mutate()} disabled={payAmount <= 0 || payMutation.isPending}>
                {payMutation.isPending ? "Recording..." : "Record Payment"}
              </Button>
            </div>
          </div>
        </DialogContent>
      </Dialog>

      <Card className="shadow-surface">
        <CardContent className="p-0">
          <div className="overflow-x-auto">
            <table className="w-full text-sm">
              <thead>
                <tr className="border-b border-border bg-muted/50">
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Bill #</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Customer</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground hidden md:table-cell">Village</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground hidden lg:table-cell">Date</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Total</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Paid</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Due</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Action</th>
                </tr>
              </thead>
              <tbody>
                {isLoading ? (
                  Array.from({ length: 3 }).map((_, i) => (
                    <tr key={i} className="border-b border-border/50">
                      <td className="py-3 px-4" colSpan={8}><Skeleton className="h-5 w-full" /></td>
                    </tr>
                  ))
                ) : filteredBills?.length === 0 ? (
                  <tr>
                    <td colSpan={8} className="text-center py-12">
                      <CreditCard className="w-10 h-10 text-muted-foreground/30 mx-auto mb-3" />
                      <p className="text-muted-foreground font-medium">No pending payments</p>
                      <p className="text-muted-foreground text-xs mt-1">All bills are paid up!</p>
                    </td>
                  </tr>
                ) : (
                  filteredBills?.map((b) => (
                    <tr key={b.id} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                      <td className="py-3 px-4 font-medium">#{b.bill_number}</td>
                      <td className="py-3 px-4 font-medium">{b.customer_name}</td>
                      <td className="py-3 px-4 text-muted-foreground hidden md:table-cell">{b.village || "—"}</td>
                      <td className="py-3 px-4 text-muted-foreground hidden lg:table-cell">{b.bill_date}</td>
                      <td className="py-3 px-4 text-right">₹{Number(b.total).toLocaleString("en-IN", { minimumFractionDigits: 2 })}</td>
                      <td className="py-3 px-4 text-right text-success font-medium">₹{Number(b.amount_paid).toLocaleString("en-IN", { minimumFractionDigits: 2 })}</td>
                      <td className="py-3 px-4 text-right">
                        <span className="inline-flex items-center px-2 py-0.5 rounded-full text-xs font-semibold bg-destructive/10 text-destructive">
                          ₹{Number(b.due_amount).toLocaleString("en-IN", { minimumFractionDigits: 2 })}
                        </span>
                      </td>
                      <td className="py-3 px-4 text-right">
                        <Button size="sm" onClick={() => { setPayDialog({ billId: b.id, due: Number(b.due_amount) }); setPayAmount(0); }}>
                          <CreditCard className="w-3 h-3 mr-1" /> Pay
                        </Button>
                      </td>
                    </tr>
                  ))
                )}
              </tbody>
            </table>
          </div>
        </CardContent>
      </Card>
    </div>
  );
}
