import { useQuery } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { Card, CardContent } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Badge } from "@/components/ui/badge";
import { Skeleton } from "@/components/ui/skeleton";
import { useState } from "react";
import { Search, Users } from "lucide-react";

export default function CustomersPage() {
  const [search, setSearch] = useState("");

  const { data: customers, isLoading } = useQuery({
    queryKey: ["customers"],
    queryFn: async () => {
      const { data, error } = await supabase.from("customers").select("*").order("name");
      if (error) throw error;
      return data;
    },
  });

  const filtered = customers?.filter((c) =>
    !search ||
    c.name.toLowerCase().includes(search.toLowerCase()) ||
    c.village.toLowerCase().includes(search.toLowerCase())
  );

  const totalDue = customers?.reduce((s, c) => s + Number(c.total_due), 0) || 0;

  return (
    <div className="space-y-4 max-w-7xl">
      <div className="flex flex-col sm:flex-row gap-3 items-start sm:items-center justify-between">
        <div>
          <p className="text-muted-foreground text-sm">{customers?.length || 0} customers</p>
          {totalDue > 0 && (
            <p className="text-xs text-destructive font-medium mt-0.5">
              Total outstanding: ₹{totalDue.toLocaleString("en-IN", { minimumFractionDigits: 2 })}
            </p>
          )}
        </div>
        <div className="relative max-w-sm w-full sm:w-auto">
          <Search className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-muted-foreground" />
          <Input placeholder="Search customers..." value={search} onChange={(e) => setSearch(e.target.value)} className="pl-9" />
        </div>
      </div>

      <Card className="shadow-surface">
        <CardContent className="p-0">
          <div className="overflow-x-auto">
            <table className="w-full text-sm">
              <thead>
                <tr className="border-b border-border bg-muted/50">
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Name</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Village</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground hidden md:table-cell">Phone</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Total Due</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Status</th>
                </tr>
              </thead>
              <tbody>
                {isLoading ? (
                  Array.from({ length: 4 }).map((_, i) => (
                    <tr key={i} className="border-b border-border/50">
                      <td className="py-3 px-4" colSpan={5}><Skeleton className="h-5 w-full" /></td>
                    </tr>
                  ))
                ) : filtered?.length === 0 ? (
                  <tr>
                    <td colSpan={5} className="text-center py-12">
                      <Users className="w-10 h-10 text-muted-foreground/30 mx-auto mb-3" />
                      <p className="text-muted-foreground font-medium">No customers yet</p>
                      <p className="text-muted-foreground text-xs mt-1">Customers are created automatically when you bill them</p>
                    </td>
                  </tr>
                ) : (
                  filtered?.map((c) => {
                    const hasDue = Number(c.total_due) > 0;
                    return (
                      <tr key={c.id} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="py-3 px-4 font-medium">{c.name}</td>
                        <td className="py-3 px-4 text-muted-foreground">{c.village || "—"}</td>
                        <td className="py-3 px-4 text-muted-foreground hidden md:table-cell">{c.phone || "—"}</td>
                        <td className="py-3 px-4 text-right">
                          <span className={`font-semibold ${hasDue ? "text-destructive" : "text-success"}`}>
                            ₹{Number(c.total_due).toLocaleString("en-IN", { minimumFractionDigits: 2 })}
                          </span>
                        </td>
                        <td className="py-3 px-4 text-right">
                          <Badge variant={hasDue ? "destructive" : "outline"} className="text-xs">
                            {hasDue ? "Due" : "Clear"}
                          </Badge>
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
