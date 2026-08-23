import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Skeleton } from "@/components/ui/skeleton";
import { useQuery } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { format, subDays } from "date-fns";
import { TrendingUp, Receipt, CreditCard, Calendar } from "lucide-react";

export default function ReportsPage() {
  const today = format(new Date(), "yyyy-MM-dd");

  const { data: todayBills, isLoading: loadingToday } = useQuery({
    queryKey: ["report-today", today],
    queryFn: async () => {
      const { data } = await supabase.from("bills").select("*").eq("bill_date", today);
      return data || [];
    },
  });

  const { data: weekBills, isLoading: loadingWeek } = useQuery({
    queryKey: ["report-week"],
    queryFn: async () => {
      const weekAgo = format(subDays(new Date(), 7), "yyyy-MM-dd");
      const { data } = await supabase.from("bills").select("*").gte("bill_date", weekAgo).order("bill_date", { ascending: false });
      return data || [];
    },
  });

  const todaySales = todayBills?.reduce((s, b) => s + Number(b.total), 0) || 0;
  const weekSales = weekBills?.reduce((s, b) => s + Number(b.total), 0) || 0;
  const todayCollected = todayBills?.reduce((s, b) => s + Number(b.amount_paid), 0) || 0;
  const weekCollected = weekBills?.reduce((s, b) => s + Number(b.amount_paid), 0) || 0;
  const todayDues = todayBills?.reduce((s, b) => s + Number(b.due_amount), 0) || 0;
  const weekDues = weekBills?.reduce((s, b) => s + Number(b.due_amount), 0) || 0;

  const loading = loadingToday || loadingWeek;

  return (
    <div className="space-y-6 max-w-7xl">
      <p className="text-muted-foreground text-sm">Sales overview and summaries</p>

      <div className="grid grid-cols-2 lg:grid-cols-4 gap-3 md:gap-4">
        {[
          { title: "Today's Sales", value: todaySales, sub: `${todayBills?.length || 0} bills`, icon: TrendingUp },
          { title: "Today Collected", value: todayCollected, sub: todayDues > 0 ? `₹${todayDues.toFixed(0)} pending` : "All collected", icon: CreditCard },
          { title: "Week Sales", value: weekSales, sub: `${weekBills?.length || 0} bills`, icon: Calendar },
          { title: "Week Collected", value: weekCollected, sub: weekDues > 0 ? `₹${weekDues.toFixed(0)} pending` : "All collected", icon: Receipt },
        ].map((stat) => (
          <Card key={stat.title} className="shadow-surface">
            <CardHeader className="pb-2 flex flex-row items-center justify-between">
              <CardTitle className="text-xs sm:text-sm text-muted-foreground font-medium">{stat.title}</CardTitle>
              <div className="w-8 h-8 rounded-lg bg-primary/10 flex items-center justify-center">
                <stat.icon className="w-4 h-4 text-primary" />
              </div>
            </CardHeader>
            <CardContent>
              {loading ? (
                <Skeleton className="h-8 w-24" />
              ) : (
                <>
                  <div className="text-xl sm:text-2xl font-heading font-bold tracking-tight">
                    ₹{stat.value.toLocaleString("en-IN", { minimumFractionDigits: 0 })}
                  </div>
                  <p className="text-xs text-muted-foreground mt-0.5">{stat.sub}</p>
                </>
              )}
            </CardContent>
          </Card>
        ))}
      </div>

      {/* Recent bills */}
      <Card className="shadow-surface">
        <CardHeader>
          <CardTitle className="text-base flex items-center gap-2">
            <Receipt className="w-4 h-4" />
            Recent Bills (Last 7 Days)
          </CardTitle>
        </CardHeader>
        <CardContent className="p-0">
          <div className="overflow-x-auto">
            <table className="w-full text-sm">
              <thead>
                <tr className="border-b border-border bg-muted/50">
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Bill #</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Customer</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground hidden md:table-cell">Date</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Total</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground hidden sm:table-cell">Paid</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Status</th>
                </tr>
              </thead>
              <tbody>
                {loading ? (
                  Array.from({ length: 3 }).map((_, i) => (
                    <tr key={i} className="border-b border-border/50">
                      <td className="py-3 px-4" colSpan={6}><Skeleton className="h-5 w-full" /></td>
                    </tr>
                  ))
                ) : weekBills?.length === 0 ? (
                  <tr>
                    <td colSpan={6} className="text-center py-12">
                      <Receipt className="w-10 h-10 text-muted-foreground/30 mx-auto mb-3" />
                      <p className="text-muted-foreground font-medium">No bills this week</p>
                    </td>
                  </tr>
                ) : (
                  weekBills?.slice(0, 25).map((b) => (
                    <tr key={b.id} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                      <td className="py-3 px-4 font-medium">#{b.bill_number}</td>
                      <td className="py-3 px-4">{b.customer_name}</td>
                      <td className="py-3 px-4 text-muted-foreground hidden md:table-cell">{b.bill_date}</td>
                      <td className="py-3 px-4 text-right font-semibold">₹{Number(b.total).toLocaleString("en-IN", { minimumFractionDigits: 2 })}</td>
                      <td className="py-3 px-4 text-right text-success hidden sm:table-cell">₹{Number(b.amount_paid).toLocaleString("en-IN", { minimumFractionDigits: 2 })}</td>
                      <td className="py-3 px-4">
                        <span className={`inline-flex items-center text-xs font-medium px-2 py-0.5 rounded-full ${
                          b.status === "paid" ? "bg-success/10 text-success" :
                          b.status === "partial" ? "bg-warning/10 text-warning" :
                          "bg-destructive/10 text-destructive"
                        }`}>
                          {b.status.charAt(0).toUpperCase() + b.status.slice(1)}
                        </span>
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
