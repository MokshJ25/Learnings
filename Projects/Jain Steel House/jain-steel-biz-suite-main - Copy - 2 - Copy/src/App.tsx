import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import { Toaster as Sonner } from "@/components/ui/sonner";
import { Toaster } from "@/components/ui/toaster";
import { TooltipProvider } from "@/components/ui/tooltip";
import { AppLayout } from "@/components/AppLayout";
import DashboardPage from "@/pages/DashboardPage";
import InventoryPage from "@/pages/InventoryPage";
import MetalPricesPage from "@/pages/MetalPricesPage";
import BillingPage from "@/pages/BillingPage";
import CustomersPage from "@/pages/CustomersPage";
import PaymentsPage from "@/pages/PaymentsPage";
import ReturnsPage from "@/pages/ReturnsPage";
import ReportsPage from "@/pages/ReportsPage";
import BillsPage from "@/pages/BillsPage";
import NotFound from "@/pages/NotFound";

const queryClient = new QueryClient();

const App = () => (
  <QueryClientProvider client={queryClient}>
    <TooltipProvider>
      <Toaster />
      <Sonner />
      <BrowserRouter>
        <AppLayout>
          <Routes>
            <Route path="/" element={<DashboardPage />} />
            <Route path="/inventory" element={<InventoryPage />} />
            <Route path="/metal-prices" element={<MetalPricesPage />} />
            <Route path="/billing" element={<BillingPage />} />
            <Route path="/customers" element={<CustomersPage />} />
            <Route path="/payments" element={<PaymentsPage />} />
            <Route path="/returns" element={<ReturnsPage />} />
            <Route path="/reports" element={<ReportsPage />} />
            <Route path="/bills" element={<BillsPage />} />
            <Route path="*" element={<NotFound />} />
          </Routes>
        </AppLayout>
      </BrowserRouter>
    </TooltipProvider>
  </QueryClientProvider>
);

export default App;
