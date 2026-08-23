import { useState, useCallback } from "react";
import { useQuery } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Package, Receipt, AlertTriangle, CreditCard, TrendingUp, Users, ArrowRight } from "lucide-react";
import { format } from "date-fns";
import { Link } from "react-router-dom";
import { Button } from "@/components/ui/button";
import { Skeleton } from "@/components/ui/skeleton";

function StatCard({ title, value, icon: Icon, description, variant = "default", loading }: {
  title: string;
  value: string | number;
  icon: React.ElementType;
  description?: string;
  variant?: "default" | "warning" | "success" | "primary";
  loading?: boolean;
}) {
  const iconColors = {
    default: "bg-secondary text-secondary-foreground",
    warning: "bg-warning/10 text-warning",
    success: "bg-success/10 text-success",
    primary: "bg-primary/10 text-primary",
  };

  return (
    <Card className="shadow-surface animate-fade-in hover:shadow-surface-lg transition-shadow">
      <CardHeader className="flex flex-row items-center justify-between pb-2">
        <CardTitle className="text-sm font-medium text-muted-foreground">{title}</CardTitle>
        <div className={`w-9 h-9 rounded-lg flex items-center justify-center ${iconColors[variant]}`}>
          <Icon className="w-4 h-4" />
        </div>
      </CardHeader>
      <CardContent>
        {loading ? (
          <Skeleton className="h-8 w-24" />
        ) : (
          <div className="text-2xl font-heading font-bold tracking-tight">{value}</div>
        )}
        {description && <p className="text-xs text-muted-foreground mt-1">{description}</p>}
      </CardContent>
    </Card>
  );
}

export default function DashboardPage() {
  const today = format(new Date(), "yyyy-MM-dd");

  const { data: itemCount, isLoading: loadingItems } = useQuery({
    queryKey: ["items-count"],
    queryFn: async () => {
      const { count } = await supabase.from("items").select("*", { count: "exact", head: true });
      return count || 0;
    },
  });

  const { data: lowStockItems, isLoading: loadingLow } = useQuery({
    queryKey: ["low-stock"],
    queryFn: async () => {
      // Fetch items where quantity <= low_stock_threshold using RPC or client filter
      const { data } = await supabase.from("items").select("*");
      return (data || []).filter((item) => item.quantity <= item.low_stock_threshold);
    },
  });

  const { data: todayBills, isLoading: loadingBills } = useQuery({
    queryKey: ["today-bills", today],
    queryFn: async () => {
      const { data } = await supabase.from("bills").select("*").eq("bill_date", today);
      return data || [];
    },
  });

  const { data: pendingDues, isLoading: loadingDues } = useQuery({
    queryKey: ["pending-dues"],
    queryFn: async () => {
      const { data } = await supabase.from("bills").select("due_amount").gt("due_amount", 0);
      return data?.reduce((sum, b) => sum + Number(b.due_amount), 0) || 0;
    },
  });

  const { data: customerCount, isLoading: loadingCustomers } = useQuery({
    queryKey: ["customer-count"],
    queryFn: async () => {
      const { count } = await supabase.from("customers").select("*", { count: "exact", head: true });
      return count || 0;
    },
  });

  const todaySales = todayBills?.reduce((sum, b) => sum + Number(b.total), 0) || 0;
  const todayCollected = todayBills?.reduce((sum, b) => sum + Number(b.amount_paid), 0) || 0;

  return (
    <div className="space-y-6 max-w-7xl">
      <div className="flex flex-col sm:flex-row sm:items-center sm:justify-between gap-2">
        <div>
          <h1 className="text-2xl font-heading font-bold tracking-tight">Welcome back 👋</h1>
          <p className="text-muted-foreground text-sm mt-0.5">Here's your store overview for today</p>
        </div>
        <Link to="/billing">
          <Button size="sm">
            <Receipt className="w-4 h-4 mr-1.5" /> New Bill
          </Button>
        </Link>
      </div>

      <div className="grid grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-3 md:gap-4">
        <StatCard title="Total Items" value={itemCount || 0} icon={Package} description="in inventory" loading={loadingItems} />
        <StatCard title="Today's Sales" value={`₹${todaySales.toLocaleString("en-IN", { minimumFractionDigits: 2 })}`} icon={TrendingUp} description={`${todayBills?.length || 0} bills`} variant="success" loading={loadingBills} />
        <StatCard title="Today Collected" value={`₹${todayCollected.toLocaleString("en-IN", { minimumFractionDigits: 2 })}`} icon={CreditCard} variant="success" loading={loadingBills} />
        <StatCard title="Pending Dues" value={`₹${(pendingDues || 0).toLocaleString("en-IN", { minimumFractionDigits: 2 })}`} icon={CreditCard} variant="warning" loading={loadingDues} />
        <StatCard title="Low Stock" value={lowStockItems?.length || 0} icon={AlertTriangle} variant="warning" description="items below threshold" loading={loadingLow} />
        <StatCard title="Customers" value={customerCount || 0} icon={Users} variant="primary" loading={loadingCustomers} />
      </div>

      {/* Quick actions */}
      <div className="grid grid-cols-2 sm:grid-cols-4 gap-3">
        {[
          { label: "New Bill", path: "/billing", icon: Receipt },
          { label: "Add Stock", path: "/inventory", icon: Package },
          { label: "Metal Prices", path: "/metal-prices", icon: CreditCard },
          { label: "View Reports", path: "/reports", icon: ArrowRight },
        ].map((action) => (
          <Link key={action.path} to={action.path}>
            <Card className="shadow-surface hover:shadow-surface-lg transition-all hover:scale-[1.02] cursor-pointer group">
              <CardContent className="p-4 flex items-center gap-3">
                <div className="w-8 h-8 rounded-lg bg-primary/10 flex items-center justify-center group-hover:bg-primary/20 transition-colors">
                  <action.icon className="w-4 h-4 text-primary" />
                </div>
                <span className="text-sm font-medium">{action.label}</span>
              </CardContent>
            </Card>
          </Link>
        ))}
      </div>

      {/* Low stock items table */}
      {loadingLow ? (
        <Card className="shadow-surface">
          <CardContent className="p-6">
            <Skeleton className="h-32 w-full" />
          </CardContent>
        </Card>
      ) : lowStockItems && lowStockItems.length > 0 ? (
        <Card className="shadow-surface">
          <CardHeader className="flex flex-row items-center justify-between">
            <CardTitle className="text-base flex items-center gap-2">
              <AlertTriangle className="w-4 h-4 text-warning" />
              Low Stock Items ({lowStockItems.length})
            </CardTitle>
            <Link to="/inventory">
              <Button variant="ghost" size="sm">View All <ArrowRight className="w-3 h-3 ml-1" /></Button>
            </Link>
          </CardHeader>
          <CardContent className="pt-0">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border">
                    <th className="text-left py-2 px-3 font-medium text-muted-foreground">Item</th>
                    <th className="text-left py-2 px-3 font-medium text-muted-foreground hidden sm:table-cell">Company</th>
                    <th className="text-left py-2 px-3 font-medium text-muted-foreground hidden md:table-cell">Variant</th>
                    <th className="text-right py-2 px-3 font-medium text-muted-foreground">Qty</th>
                    <th className="text-right py-2 px-3 font-medium text-muted-foreground">Threshold</th>
                  </tr>
                </thead>
                <tbody>
                  {lowStockItems.slice(0, 10).map((item) => (
                    <tr key={item.id} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                      <td className="py-2.5 px-3 font-medium">{item.item_name}</td>
                      <td className="py-2.5 px-3 text-muted-foreground hidden sm:table-cell">{item.company || "—"}</td>
                      <td className="py-2.5 px-3 text-muted-foreground hidden md:table-cell">{item.variant || "—"}</td>
                      <td className="py-2.5 px-3 text-right">
                        <span className="inline-flex items-center px-2 py-0.5 rounded-full text-xs font-semibold bg-destructive/10 text-destructive">
                          {item.quantity}
                        </span>
                      </td>
                      <td className="py-2.5 px-3 text-right text-muted-foreground">{item.low_stock_threshold}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </CardContent>
        </Card>
      ) : null}
    </div>
  );
}
