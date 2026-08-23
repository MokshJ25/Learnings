import { useState } from "react";
import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Card, CardContent } from "@/components/ui/card";
import { Dialog, DialogContent, DialogHeader, DialogTitle, DialogTrigger } from "@/components/ui/dialog";
import { Label } from "@/components/ui/label";
import { Badge } from "@/components/ui/badge";
import { Skeleton } from "@/components/ui/skeleton";
import { toast } from "sonner";
import { Plus, Pencil, Trash2, Gem } from "lucide-react";

export default function MetalPricesPage() {
  const queryClient = useQueryClient();
  const [dialogOpen, setDialogOpen] = useState(false);
  const [editId, setEditId] = useState<string | null>(null);
  const [form, setForm] = useState({ metal_type: "", company: "", price_per_kg: 0 });

  const { data: prices, isLoading } = useQuery({
    queryKey: ["metal-prices"],
    queryFn: async () => {
      const { data, error } = await supabase.from("metal_prices").select("*").order("metal_type");
      if (error) throw error;
      return data;
    },
  });

  const saveMutation = useMutation({
    mutationFn: async () => {
      if (!form.metal_type.trim()) throw new Error("Metal type is required");
      if (form.price_per_kg <= 0) throw new Error("Price must be greater than 0");
      if (editId) {
        const { error } = await supabase.from("metal_prices").update(form).eq("id", editId);
        if (error) throw error;
      } else {
        const { error } = await supabase.from("metal_prices").insert(form);
        if (error) throw error;
      }
    },
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["metal-prices"] });
      toast.success(editId ? "Price updated" : "Price added");
      setDialogOpen(false);
      resetForm();
    },
    onError: (e) => toast.error(e.message),
  });

  const deleteMutation = useMutation({
    mutationFn: async (id: string) => {
      const { error } = await supabase.from("metal_prices").delete().eq("id", id);
      if (error) throw error;
    },
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["metal-prices"] });
      toast.success("Price deleted");
    },
  });

  const resetForm = () => {
    setForm({ metal_type: "", company: "", price_per_kg: 0 });
    setEditId(null);
  };

  // Group prices by metal type for better display
  const metalGroups = prices?.reduce((acc, p) => {
    if (!acc[p.metal_type]) acc[p.metal_type] = [];
    acc[p.metal_type].push(p);
    return acc;
  }, {} as Record<string, typeof prices>);

  return (
    <div className="space-y-4 max-w-7xl">
      <div className="flex justify-between items-center">
        <div>
          <p className="text-muted-foreground text-sm">Manage metal rates for weight-based billing</p>
          <p className="text-xs text-muted-foreground mt-0.5">{prices?.length || 0} rates configured</p>
        </div>
        <Dialog open={dialogOpen} onOpenChange={(open) => { setDialogOpen(open); if (!open) resetForm(); }}>
          <DialogTrigger asChild>
            <Button><Plus className="w-4 h-4 mr-1.5" /> Add Price</Button>
          </DialogTrigger>
          <DialogContent>
            <DialogHeader>
              <DialogTitle className="flex items-center gap-2">
                <Gem className="w-5 h-5" />
                {editId ? "Edit" : "Add"} Metal Price
              </DialogTitle>
            </DialogHeader>
            <form onSubmit={(e) => { e.preventDefault(); saveMutation.mutate(); }} className="space-y-4">
              <div className="space-y-1.5">
                <Label>Metal Type *</Label>
                <Input value={form.metal_type} onChange={(e) => setForm({ ...form, metal_type: e.target.value })} placeholder="e.g. Steel, Iron, Copper" autoFocus />
              </div>
              <div className="space-y-1.5">
                <Label>Company / Vendor</Label>
                <Input value={form.company} onChange={(e) => setForm({ ...form, company: e.target.value })} placeholder="e.g. Bhulani, General" />
              </div>
              <div className="space-y-1.5">
                <Label>Price per KG (₹) *</Label>
                <Input type="number" step="0.01" min="0" value={form.price_per_kg || ""} onChange={(e) => setForm({ ...form, price_per_kg: parseFloat(e.target.value) || 0 })} placeholder="0.00" />
              </div>
              <div className="flex justify-end gap-2 pt-2 border-t border-border">
                <Button type="button" variant="outline" onClick={() => { setDialogOpen(false); resetForm(); }}>Cancel</Button>
                <Button type="submit" disabled={saveMutation.isPending}>{saveMutation.isPending ? "Saving..." : "Save"}</Button>
              </div>
            </form>
          </DialogContent>
        </Dialog>
      </div>

      <Card className="shadow-surface">
        <CardContent className="p-0">
          <div className="overflow-x-auto">
            <table className="w-full text-sm">
              <thead>
                <tr className="border-b border-border bg-muted/50">
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Metal Type</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Company / Vendor</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Price/KG</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground w-24">Actions</th>
                </tr>
              </thead>
              <tbody>
                {isLoading ? (
                  Array.from({ length: 3 }).map((_, i) => (
                    <tr key={i} className="border-b border-border/50">
                      <td className="py-3 px-4" colSpan={4}><Skeleton className="h-5 w-full" /></td>
                    </tr>
                  ))
                ) : prices?.length === 0 ? (
                  <tr>
                    <td colSpan={4} className="text-center py-12">
                      <Gem className="w-10 h-10 text-muted-foreground/30 mx-auto mb-3" />
                      <p className="text-muted-foreground font-medium">No metal prices added</p>
                      <p className="text-muted-foreground text-xs mt-1">Add rates to use in weight-based billing</p>
                    </td>
                  </tr>
                ) : (
                  prices?.map((p) => (
                    <tr key={p.id} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                      <td className="py-3 px-4">
                        <Badge variant="outline" className="capitalize">{p.metal_type}</Badge>
                      </td>
                      <td className="py-3 px-4 text-muted-foreground">{p.company || "General"}</td>
                      <td className="py-3 px-4 text-right font-heading font-bold text-primary">₹{p.price_per_kg}</td>
                      <td className="py-3 px-4 text-right">
                        <div className="flex justify-end gap-0.5">
                          <Button variant="ghost" size="icon" className="h-8 w-8" onClick={() => {
                            setForm({ metal_type: p.metal_type, company: p.company, price_per_kg: p.price_per_kg });
                            setEditId(p.id);
                            setDialogOpen(true);
                          }}>
                            <Pencil className="w-3.5 h-3.5" />
                          </Button>
                          <Button variant="ghost" size="icon" className="h-8 w-8" onClick={() => {
                            if (confirm("Delete this price?")) deleteMutation.mutate(p.id);
                          }}>
                            <Trash2 className="w-3.5 h-3.5 text-destructive" />
                          </Button>
                        </div>
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
