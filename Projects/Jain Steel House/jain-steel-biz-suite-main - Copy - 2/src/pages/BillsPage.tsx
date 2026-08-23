import { useState } from "react";
import { useQuery } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { Badge } from "@/components/ui/badge";
import { Skeleton } from "@/components/ui/skeleton";
import { Search, Download, Receipt } from "lucide-react";
import { format } from "date-fns";
import jsPDF from "jspdf";

export default function BillsPage() {
  const [search, setSearch] = useState("");

  const { data: bills, isLoading } = useQuery({
    queryKey: ["all-bills"],
    queryFn: async () => {
      const { data, error } = await supabase
        .from("bills")
        .select(`
          *,
          bill_items (*)
        `)
        .order("created_at", { ascending: false });
      if (error) throw error;
      return data;
    },
  });

  const filteredBills = bills?.filter((bill) =>
    !search ||
    bill.customer_name.toLowerCase().includes(search.toLowerCase()) ||
    bill.bill_number.toString().includes(search)
  );

  const generateBillPDF = async (bill: any, type: "raw" | "gst") => {
    const billData = {
      ...bill,
      items: bill.bill_items || [],
    };

    if (type === "raw") {
      const doc = new jsPDF();
      const pageWidth = doc.internal.pageSize.getWidth();
      let yPosition = 20;

      doc.setFontSize(20);
      doc.text("Jain Steel House", pageWidth / 2, yPosition, { align: "center" });
      yPosition += 15;

      doc.setFontSize(12);
      doc.text(`Bill No: ${billData.bill_number}`, 20, yPosition);
      doc.text(`Date: ${format(new Date(billData.bill_date), "dd/MM/yyyy")}`, pageWidth - 20, yPosition, { align: "right" });
      yPosition += 10;

      doc.text(`Customer: ${billData.customer_name}`, 20, yPosition);
      if (billData.village) {
        doc.text(`Village: ${billData.village}`, pageWidth - 20, yPosition, { align: "right" });
      }
      yPosition += 15;

      // Table
      const headers = ["S.No.", "Description", "Qty", "Type", "Rate", "Amount"];
      const columnWidths = [15, 60, 20, 25, 30, 35];
      let xPosition = 20;

      doc.setFontSize(10);
      headers.forEach((header, index) => {
        doc.text(header, xPosition, yPosition);
        xPosition += columnWidths[index];
      });

      yPosition += 5;
      doc.line(20, yPosition, pageWidth - 20, yPosition);
      yPosition += 8;

      billData.items.forEach((item: any, index: number) => {
        xPosition = 20;
        doc.text(String(index + 1), xPosition, yPosition);
        xPosition += columnWidths[0];

        doc.text(item.item_name, xPosition, yPosition);
        xPosition += columnWidths[1];

        doc.text(String(item.quantity || item.weight), xPosition, yPosition);
        xPosition += columnWidths[2];

        doc.text(item.selling_type === "per_piece" ? "Pieces" : "Weight", xPosition, yPosition);
        xPosition += columnWidths[3];

        doc.text(`₹${item.price}`, xPosition, yPosition);
        xPosition += columnWidths[4];

        doc.text(`₹${item.total.toFixed(2)}`, xPosition, yPosition);
        yPosition += 8;
      });

      yPosition += 5;
      doc.line(20, yPosition, pageWidth - 20, yPosition);
      yPosition += 8;

      doc.setFontSize(12);
      doc.text(`Total: ₹${billData.total.toFixed(2)}`, pageWidth - 60, yPosition);
      yPosition += 10;

      if (billData.amount_paid > 0) {
        doc.text(`Paid: ₹${billData.amount_paid.toFixed(2)}`, pageWidth - 60, yPosition);
        yPosition += 8;
      }

      if (billData.due_amount > 0) {
        doc.text(`Due: ₹${billData.due_amount.toFixed(2)}`, pageWidth - 60, yPosition);
      }

      doc.save(`Bill_${billData.bill_number}_${billData.customer_name.replace(/\s+/g, '_')}.pdf`);
    } else {
      // GST Invoice
      const doc = new jsPDF();
      const pageWidth = doc.internal.pageSize.getWidth();
      let yPosition = 20;

      doc.setFontSize(20);
      doc.setFont("helvetica", "bold");
      doc.text("Jain Steel House", pageWidth / 2, yPosition, { align: "center" });
      yPosition += 8;

      doc.setFontSize(12);
      doc.setFont("helvetica", "normal");
      doc.text("Main Road, Karahi(Khargone), State: Madhya Pradesh, Code: 23", pageWidth / 2, yPosition, { align: "center" });
      yPosition += 6;
      doc.text("GST Number: 23AKSPJ8880F1ZP", pageWidth / 2, yPosition, { align: "center" });
      yPosition += 15;

      doc.setFontSize(16);
      doc.setFont("helvetica", "bold");
      doc.text("TAX INVOICE", pageWidth / 2, yPosition, { align: "center" });
      yPosition += 15;

      doc.setFontSize(10);
      doc.setFont("helvetica", "normal");
      doc.text(`Invoice No: ${billData.bill_number}`, 20, yPosition);
      doc.text(`Date: ${format(new Date(billData.bill_date), "dd/MM/yyyy")}`, pageWidth - 20, yPosition, { align: "right" });
      yPosition += 8;

      doc.text(`Customer: ${billData.customer_name}`, 20, yPosition);
      if (billData.village) {
        doc.text(`Village: ${billData.village}`, pageWidth - 20, yPosition, { align: "right" });
      }
      yPosition += 15;

      // GST Table
      const headers = ["Description of Goods", "GST Rate", "Quantity", "Rate (incl. tax)", "Amount"];
      const columnWidths = [50, 20, 20, 40, 35];
      let xPosition = 20;

      doc.setFontSize(9);
      headers.forEach((header, index) => {
        doc.text(header, xPosition, yPosition);
        xPosition += columnWidths[index];
      });

      yPosition += 5;
      doc.line(20, yPosition, pageWidth - 20, yPosition);
      yPosition += 8;

      billData.items.forEach((item: any) => {
        xPosition = 20;
        doc.text(item.item_name, xPosition, yPosition);
        xPosition += columnWidths[0];

        doc.text(`${item.gst_rate}%`, xPosition, yPosition);
        xPosition += columnWidths[1];

        doc.text(String(item.quantity || item.weight), xPosition, yPosition);
        xPosition += columnWidths[2];

        doc.text(`₹${item.price}`, xPosition, yPosition);
        xPosition += columnWidths[3];

        doc.text(`₹${item.total.toFixed(2)}`, xPosition, yPosition);
        yPosition += 8;
      });

      yPosition += 5;
      doc.line(20, yPosition, pageWidth - 20, yPosition);
      yPosition += 8;

      doc.setFontSize(10);
      doc.text(`Total Amount: ₹${billData.subtotal.toFixed(2)}`, pageWidth - 60, yPosition);
      yPosition += 8;

      if (billData.discount > 0) {
        doc.text(`Discount: ₹${billData.discount.toFixed(2)}`, pageWidth - 60, yPosition);
        yPosition += 8;
      }

      if (billData.cgst_amount > 0 || billData.sgst_amount > 0) {
        doc.text(`CGST (${billData.cgst_percent}%): ₹${billData.cgst_amount.toFixed(2)}`, pageWidth - 60, yPosition);
        yPosition += 6;
        doc.text(`SGST (${billData.sgst_percent}%): ₹${billData.sgst_amount.toFixed(2)}`, pageWidth - 60, yPosition);
        yPosition += 8;
      }

      doc.setFontSize(12);
      doc.setFont("helvetica", "bold");
      doc.text(`Grand Total: ₹${billData.total.toFixed(2)}`, pageWidth - 60, yPosition);

      doc.save(`GST_Invoice_${billData.bill_number}_${billData.customer_name.replace(/\s+/g, '_')}.pdf`);
    }
  };

  return (
    <div className="space-y-4 max-w-7xl">
      <div className="flex flex-col sm:flex-row gap-3 items-start sm:items-center justify-between">
        <div>
          <p className="text-muted-foreground text-sm">{filteredBills?.length || 0} bills found</p>
        </div>
        <div className="relative max-w-sm w-full sm:w-auto">
          <Search className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-muted-foreground" />
          <Input placeholder="Search bills..." value={search} onChange={(e) => setSearch(e.target.value)} className="pl-9" />
        </div>
      </div>

      <Card className="shadow-surface">
        <CardContent className="p-0">
          <div className="overflow-x-auto">
            <table className="w-full text-sm">
              <thead>
                <tr className="border-b border-border bg-muted/50">
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Bill #</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground">Customer</th>
                  <th className="text-left py-3 px-4 font-medium text-muted-foreground hidden md:table-cell">Date</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Total</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Status</th>
                  <th className="text-right py-3 px-4 font-medium text-muted-foreground">Actions</th>
                </tr>
              </thead>
              <tbody>
                {isLoading ? (
                  Array.from({ length: 5 }).map((_, i) => (
                    <tr key={i} className="border-b border-border/50">
                      <td className="py-3 px-4" colSpan={6}><Skeleton className="h-5 w-full" /></td>
                    </tr>
                  ))
                ) : filteredBills?.length === 0 ? (
                  <tr>
                    <td colSpan={6} className="text-center py-12">
                      <Receipt className="w-10 h-10 text-muted-foreground/30 mx-auto mb-3" />
                      <p className="text-muted-foreground font-medium">No bills found</p>
                      <p className="text-muted-foreground text-xs mt-1">Bills will appear here once created</p>
                    </td>
                  </tr>
                ) : (
                  filteredBills?.map((bill) => {
                    const hasDue = Number(bill.due_amount) > 0;
                    return (
                      <tr key={bill.id} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="py-3 px-4 font-medium">#{bill.bill_number}</td>
                        <td className="py-3 px-4">{bill.customer_name}</td>
                        <td className="py-3 px-4 text-muted-foreground hidden md:table-cell">
                          {format(new Date(bill.bill_date), "dd/MM/yyyy")}
                        </td>
                        <td className="py-3 px-4 text-right font-semibold">
                          ₹{Number(bill.total).toLocaleString("en-IN", { minimumFractionDigits: 2 })}
                        </td>
                        <td className="py-3 px-4 text-right">
                          <Badge variant={hasDue ? "destructive" : "outline"} className="text-xs">
                            {bill.status}
                          </Badge>
                        </td>
                        <td className="py-3 px-4 text-right">
                          <div className="flex gap-1 justify-end">
                            <Button
                              variant="ghost"
                              size="sm"
                              onClick={() => generateBillPDF(bill, "raw")}
                              className="h-8 px-2"
                            >
                              <Download className="w-3 h-3 mr-1" />
                              Raw
                            </Button>
                            <Button
                              variant="ghost"
                              size="sm"
                              onClick={() => generateBillPDF(bill, "gst")}
                              className="h-8 px-2"
                            >
                              <Download className="w-3 h-3 mr-1" />
                              GST
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