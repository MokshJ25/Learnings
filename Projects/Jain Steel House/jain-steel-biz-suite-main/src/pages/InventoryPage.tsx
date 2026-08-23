import { useState, useCallback } from "react";
import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Card, CardContent } from "@/components/ui/card";
import { Dialog, DialogContent, DialogHeader, DialogTitle, DialogTrigger } from "@/components/ui/dialog";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { Label } from "@/components/ui/label";
import { Badge } from "@/components/ui/badge";
import { Skeleton } from "@/components/ui/skeleton";
import { toast } from "sonner";
import { Plus, Search, Pencil, Trash2, Package } from "lucide-react";
import type { Database } from "@/integrations/supabase/types";

type Item = Database["public"]["Tables"]["items"]["Row"];
type ItemInsert = Database["public"]["Tables"]["items"]["Insert"];

const metalTypes = ["steel", "iron", "copper", "bronze", "aluminium", "brass", "other"];

function ItemForm({ item, onSave, onClose }: { item?: Item; onSave: (data: ItemInsert) => void; onClose: () => void }) {
  const [form, setForm] = useState<ItemInsert>({
    item_name: item?.item_name || "",
    item_type: item?.item_type || "",
    company: item?.company || "",
    variant: item?.variant || "",
    quantity: item?.quantity || 0,
    selling_type: item?.selling_type || "per_piece",
    price: item?.price || 0,
    price_per_kg: item?.price_per_kg || 0,
    metal_type: item?.metal_type || "steel",
    low_stock_threshold: item?.low_stock_threshold || 5,
  });

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!form.item_name?.trim()) {
      toast.error("Item name is required");
      return;
    }
    onSave(form);
  };

  return (
    <form onSubmit={handleSubmit} className="space-y-4">
      <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
        <div className="space-y-1.5">
          <Label className="text-sm font-medium">Item Name *</Label>
          <Input value={form.item_name} onChange={(e) => setForm({ ...form, item_name: e.target.value })} placeholder="e.g. Pressure Cooker" autoFocus />
        </div>
        <div className="space-y-1.5">
          <Label className="text-sm font-medium">Item Type / Category</Label>
          <Input value={form.item_type || ""} onChange={(e) => setForm({ ...form, item_type: e.target.value })} placeholder="e.g. Cookware" />
        </div>
        <div className="space-y-1.5">
          <Label className="text-sm font-medium">Company / Brand</Label>
          <Input value={form.company || ""} onChange={(e) => setForm({ ...form, company: e.target.value })} placeholder="e.g. Cello" />
        </div>
        <div className="space-y-1.5">
          <Label className="text-sm font-medium">Variant / Size</Label>
          <Input value={form.variant || ""} onChange={(e) => setForm({ ...form, variant: e.target.value })} placeholder="e.g. 5L, Medium" />
        </div>
        <div className="space-y-1.5">
          <Label className="text-sm font-medium">Quantity in Stock</Label>
          <Input type="number" min="0" value={form.quantity} onChange={(e) => setForm({ ...form, quantity: Math.max(0, parseInt(e.target.value) || 0) })} />
        </div>
        <div className="space-y-1.5">
          <Label className="text-sm font-medium">Selling Type</Label>
          <Select value={form.selling_type} onValueChange={(v) => setForm({ ...form, selling_type: v as "per_piece" | "per_weight" })}>
            <SelectTrigger><SelectValue /></SelectTrigger>
            <SelectContent>
              <SelectItem value="per_piece">Per Piece</SelectItem>
              <SelectItem value="per_weight">Per Weight (KG)</SelectItem>
            </SelectContent>
          </Select>
        </div>
        <div className="space-y-1.5">
          <Label className="text-sm font-medium">Metal Type</Label>
          <Select value={form.metal_type || "steel"} onValueChange={(v) => setForm({ ...form, metal_type: v })}>
            <SelectTrigger><SelectValue /></SelectTrigger>
            <SelectContent>
              {metalTypes.map((m) => (
                <SelectItem key={m} value={m}>{m.charAt(0).toUpperCase() + m.slice(1)}</SelectItem>
              ))}
            </SelectContent>
          </Select>
        </div>
        {form.selling_type === "per_piece" ? (
          <div className="space-y-1.5">
            <Label className="text-sm font-medium">Price per Piece (₹)</Label>
            <Input type="number" step="0.01" min="0" value={form.price} onChange={(e) => setForm({ ...form, price: parseFloat(e.target.value) || 0 })} />
          </div>
        ) : (
          <div className="space-y-1.5">
            <Label className="text-sm font-medium">Price per KG (₹)</Label>
            <Input type="number" step="0.01" min="0" value={form.price_per_kg} onChange={(e) => setForm({ ...form, price_per_kg: parseFloat(e.target.value) || 0 })} />
          </div>
        )}
        <div className="space-y-1.5">
          <Label className="text-sm font-medium">Low Stock Threshold</Label>
          <Input type="number" min="0" value={form.low_stock_threshold} onChange={(e) => setForm({ ...form, low_stock_threshold: Math.max(0, parseInt(e.target.value) || 0) })} />
        </div>
      </div>
      <div className="flex justify-end gap-2 pt-3 border-t border-border">
        <Button type="button" variant="outline" onClick={onClose}>Cancel</Button>
        <Button type="submit">{item ? "Update" : "Add"} Item</Button>
      </div>
    </form>
  );
}

export default function InventoryPage() {
  const queryClient = useQueryClient();
  const [search, setSearch] = useState("");
  const [debouncedSearch, setDebouncedSearch] = useState("");
  const [filterMetal, setFilterMetal] = useState<string>("all");
  const [editItem, setEditItem] = useState<Item | undefined>();
  const [dialogOpen, setDialogOpen] = useState(false);
  const [searchTimeout, setSearchTimeout] = useState<ReturnType<typeof setTimeout> | null>(null);

  const handleSearch = useCallback((value: string) => {
    setSearch(value);
    if (searchTimeout) clearTimeout(searchTimeout);
    setSearchTimeout(setTimeout(() => setDebouncedSearch(value), 300));
  }, [searchTimeout]);

  const { data: items, isLoading } = useQuery({
    queryKey: ["items", debouncedSearch, filterMetal],
    queryFn: async () => {
      let query = supabase.from("items").select("*").order("item_name");
      if (debouncedSearch) query = query.ilike("item_name", `%${debouncedSearch}%`);
      if (filterMetal !== "all") query = query.eq("metal_type", filterMetal);
      const { data, error } = await query;
      if (error) throw error;
      return data;
    },
  });

  const addMutation = useMutation({
    mutationFn: async (item: ItemInsert) => {
      const { error } = await supabase.from("items").insert(item);
      if (error) throw error;
    },
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["items"] });
      toast.success("Item added successfully");
      setDialogOpen(false);
    },
    onError: (e) => toast.error(e.message),
  });

  const updateMutation = useMutation({
    mutationFn: async ({ id, ...data }: ItemInsert & { id: string }) => {
      const { error } = await supabase.from("items").update(data).eq("id", id);
      if (error) throw error;
    },
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["items"] });
      toast.success("Item updated");
      setDialogOpen(false);
      setEditItem(undefined);
    },
    onError: (e) => toast.error(e.message),
  });

  const deleteMutation = useMutation({
    mutationFn: async (id: string) => {
      const { error } = await supabase.from("items").delete().eq("id", id);
      if (error) throw error;
    },
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["items"] });
      toast.success("Item deleted");
    },
    onError: (e) => toast.error(e.message),
  });

  const handleSave = (data: ItemInsert) => {
    if (editItem) {
      updateMutation.mutate({ ...data, id: editItem.id });
    } else {
      addMutation.mutate(data);
    }
  };

  return (
    <div className="space-y-4 max-w-7xl">
      <div className="flex flex-col sm:flex-row gap-3 items-start sm:items-center justify-between">
        <div className="flex gap-2 flex-1 w-full sm:w-auto">
          <div className="relative flex-1 max-w-sm">
            <Search className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-muted-foreground" />
            <Input placeholder="Search items..." value={search} onChange={(e) => handleSearch(e.target.value)} className="pl-9" />
          </div>
          <Select value={filterMetal} onValueChange={setFilterMetal}>
            <SelectTrigger className="w-32 sm:w-36"><SelectValue placeholder="Metal" /></SelectTrigger>
            <SelectContent>
              <SelectItem value="all">All Metals</SelectItem>
              {metalTypes.map((m) => (
                <SelectItem key={m} value={m}>{m.charAt(0).toUpperCase() + m.slice(1)}</SelectItem>
              ))}
            </SelectContent>
          </Select>
        </div>
        <Dialog open={dialogOpen} onOpenChange={(open) => { setDialogOpen(open); if (!open) setEditItem(undefined); }}>
          <DialogTrigger asChild>
            <Button><Plus className="w-4 h-4 mr-1.5" /> Add Item</Button>
          </DialogTrigger>
          <DialogContent className="max-w-2xl max-h-[90vh] overflow-y-auto">
            <DialogHeader>
              <DialogTitle className="flex items-center gap-2">
                <Package className="w-5 h-5" />
                {editItem ? "Edit Item" : "Add New Item"}
              </DialogTitle>
            </DialogHeader>
            <ItemForm item={editItem} onSave={handleSave} onClose={() => { setDialogOpen(false); setEditItem(undefined); }} />
          </DialogContent>
        </Dialog>
      </div>

      {items && !isLoading && (
        <p className="text-xs text-muted-foreground">{items.length} item{items.length !== 1 ? "s" : ""} found</p>
      )}

      <Card className="shadow-surface">
        <CardContent className="p-0">
          <div className="overflow-x-auto">
            <table className="w-full text-sm">
              <thead>
                <tr className="border-b border-border bg-muted/50">
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Item</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground hidden md:table-cell">Company</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground hidden lg:table-cell">Variant</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground hidden lg:table-cell">Metal</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground hidden xl:table-cell">Type</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Qty</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Price</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground w-24">Actions</th>
                </tr>
              </thead>
              <tbody>
                {isLoading ? (
                  Array.from({ length: 5 }).map((_, i) => (
                    <tr key={i} className="border-b border-border/50">
                      <td className="py-3 px-4" colSpan={8}><Skeleton className="h-5 w-full" /></td>
                    </tr>
                  ))
                ) : items?.length === 0 ? (
                  <tr>
                    <td colSpan={8} className="text-center py-12">
                      <Package className="w-10 h-10 text-muted-foreground/30 mx-auto mb-3" />
                      <p className="text-muted-foreground font-medium">No items found</p>
                      <p className="text-muted-foreground text-xs mt-1">Add your first item to get started</p>
                    </td>
                  </tr>
                ) : (
                  items?.map((item) => {
                    const isLow = item.quantity <= item.low_stock_threshold;
                    return (
                      <tr key={item.id} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="py-3 px-4">
                          <div className="font-medium">{item.item_name}</div>
                          <div className="text-xs text-muted-foreground md:hidden mt-0.5">
                            {[item.company, item.variant].filter(Boolean).join(" • ")}
                          </div>
                        </td>
                        <td className="py-3 px-4 text-muted-foreground hidden md:table-cell">{item.company || "—"}</td>
                        <td className="py-3 px-4 text-muted-foreground hidden lg:table-cell">{item.variant || "—"}</td>
                        <td className="py-3 px-4 hidden lg:table-cell">
                          <Badge variant="outline" className="capitalize text-xs">{item.metal_type}</Badge>
                        </td>
                        <td className="py-3 px-4 hidden xl:table-cell">
                          <span className={`text-xs px-2 py-0.5 rounded-full ${
                            item.selling_type === "per_piece" ? "bg-primary/10 text-primary" : "bg-accent text-accent-foreground"
                          }`}>
                            {item.selling_type === "per_piece" ? "Piece" : "Weight"}
                          </span>
                        </td>
                        <td className="py-3 px-4 text-right">
                          {isLow ? (
                            <span className="inline-flex items-center px-2 py-0.5 rounded-full text-xs font-semibold bg-destructive/10 text-destructive">
                              {item.quantity}
                            </span>
                          ) : (
                            <span className="font-medium">{item.quantity}</span>
                          )}
                        </td>
                        <td className="py-3 px-4 text-right font-medium">
                          {item.selling_type === "per_piece" ? `₹${item.price}` : `₹${item.price_per_kg}/kg`}
                        </td>
                        <td className="py-3 px-4 text-right">
                          <div className="flex justify-end gap-0.5">
                            <Button variant="ghost" size="icon" className="h-8 w-8" onClick={() => { setEditItem(item); setDialogOpen(true); }}>
                              <Pencil className="w-3.5 h-3.5" />
                            </Button>
                            <Button variant="ghost" size="icon" className="h-8 w-8" onClick={() => {
                              if (confirm(`Delete "${item.item_name}"? This cannot be undone.`)) deleteMutation.mutate(item.id);
                            }}>
                              <Trash2 className="w-3.5 h-3.5 text-destructive" />
                            </Button>
                          </div>
                        </td>
                      </tr>
                    );
                  })
                )}
              </tbody>
            </table>
          </div>
        </CardContent>
      </Card>
    </div>
  );
}
