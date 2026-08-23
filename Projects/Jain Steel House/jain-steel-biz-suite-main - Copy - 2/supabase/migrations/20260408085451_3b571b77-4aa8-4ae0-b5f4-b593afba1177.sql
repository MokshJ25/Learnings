
-- Create enum for selling type
CREATE TYPE public.selling_type AS ENUM ('per_piece', 'per_weight');

-- Items table
CREATE TABLE public.items (
  id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
  item_name TEXT NOT NULL,
  item_type TEXT NOT NULL DEFAULT '',
  company TEXT NOT NULL DEFAULT '',
  variant TEXT NOT NULL DEFAULT '',
  quantity INTEGER NOT NULL DEFAULT 0,
  selling_type public.selling_type NOT NULL DEFAULT 'per_piece',
  price NUMERIC(10,2) NOT NULL DEFAULT 0,
  price_per_kg NUMERIC(10,2) NOT NULL DEFAULT 0,
  metal_type TEXT NOT NULL DEFAULT 'steel',
  low_stock_threshold INTEGER NOT NULL DEFAULT 5,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);

ALTER TABLE public.items ENABLE ROW LEVEL SECURITY;
CREATE POLICY "Allow all access to items" ON public.items FOR ALL USING (true) WITH CHECK (true);

-- Metal prices table
CREATE TABLE public.metal_prices (
  id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
  metal_type TEXT NOT NULL,
  company TEXT NOT NULL DEFAULT '',
  price_per_kg NUMERIC(10,2) NOT NULL DEFAULT 0,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);

ALTER TABLE public.metal_prices ENABLE ROW LEVEL SECURITY;
CREATE POLICY "Allow all access to metal_prices" ON public.metal_prices FOR ALL USING (true) WITH CHECK (true);

-- Customers table
CREATE TABLE public.customers (
  id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
  name TEXT NOT NULL,
  village TEXT NOT NULL DEFAULT '',
  phone TEXT NOT NULL DEFAULT '',
  total_due NUMERIC(10,2) NOT NULL DEFAULT 0,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);

ALTER TABLE public.customers ENABLE ROW LEVEL SECURITY;
CREATE POLICY "Allow all access to customers" ON public.customers FOR ALL USING (true) WITH CHECK (true);

-- Bills table
CREATE TABLE public.bills (
  id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
  bill_number SERIAL,
  customer_name TEXT NOT NULL,
  village TEXT NOT NULL DEFAULT '',
  bill_date DATE NOT NULL DEFAULT CURRENT_DATE,
  subtotal NUMERIC(10,2) NOT NULL DEFAULT 0,
  discount NUMERIC(10,2) NOT NULL DEFAULT 0,
  cgst_percent NUMERIC(5,2) NOT NULL DEFAULT 0,
  sgst_percent NUMERIC(5,2) NOT NULL DEFAULT 0,
  cgst_amount NUMERIC(10,2) NOT NULL DEFAULT 0,
  sgst_amount NUMERIC(10,2) NOT NULL DEFAULT 0,
  total NUMERIC(10,2) NOT NULL DEFAULT 0,
  amount_paid NUMERIC(10,2) NOT NULL DEFAULT 0,
  due_amount NUMERIC(10,2) NOT NULL DEFAULT 0,
  status TEXT NOT NULL DEFAULT 'paid' CHECK (status IN ('paid', 'partial', 'pending')),
  created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);

ALTER TABLE public.bills ENABLE ROW LEVEL SECURITY;
CREATE POLICY "Allow all access to bills" ON public.bills FOR ALL USING (true) WITH CHECK (true);

-- Bill items table
CREATE TABLE public.bill_items (
  id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
  bill_id UUID NOT NULL REFERENCES public.bills(id) ON DELETE CASCADE,
  item_id UUID REFERENCES public.items(id) ON DELETE SET NULL,
  item_name TEXT NOT NULL,
  variant TEXT NOT NULL DEFAULT '',
  selling_type public.selling_type NOT NULL DEFAULT 'per_piece',
  quantity INTEGER NOT NULL DEFAULT 0,
  weight NUMERIC(10,3) NOT NULL DEFAULT 0,
  price NUMERIC(10,2) NOT NULL DEFAULT 0,
  gst_rate NUMERIC(5,2) NOT NULL DEFAULT 0,
  gst_amount NUMERIC(10,2) NOT NULL DEFAULT 0,
  total NUMERIC(10,2) NOT NULL DEFAULT 0,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);

ALTER TABLE public.bill_items ENABLE ROW LEVEL SECURITY;
CREATE POLICY "Allow all access to bill_items" ON public.bill_items FOR ALL USING (true) WITH CHECK (true);

-- Payments table
CREATE TABLE public.payments (
  id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
  bill_id UUID NOT NULL REFERENCES public.bills(id) ON DELETE CASCADE,
  amount NUMERIC(10,2) NOT NULL DEFAULT 0,
  payment_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
  notes TEXT NOT NULL DEFAULT '',
  created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);

ALTER TABLE public.payments ENABLE ROW LEVEL SECURITY;
CREATE POLICY "Allow all access to payments" ON public.payments FOR ALL USING (true) WITH CHECK (true);

-- Returns table
CREATE TABLE public.returns (
  id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
  bill_id UUID NOT NULL REFERENCES public.bills(id) ON DELETE CASCADE,
  bill_item_id UUID NOT NULL REFERENCES public.bill_items(id) ON DELETE CASCADE,
  return_quantity INTEGER NOT NULL DEFAULT 0,
  return_weight NUMERIC(10,3) NOT NULL DEFAULT 0,
  reason TEXT NOT NULL DEFAULT '',
  refund_amount NUMERIC(10,2) NOT NULL DEFAULT 0,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);

ALTER TABLE public.returns ENABLE ROW LEVEL SECURITY;
CREATE POLICY "Allow all access to returns" ON public.returns FOR ALL USING (true) WITH CHECK (true);

-- Indexes for performance
CREATE INDEX idx_items_name ON public.items(item_name);
CREATE INDEX idx_items_company ON public.items(company);
CREATE INDEX idx_items_metal_type ON public.items(metal_type);
CREATE INDEX idx_items_item_type ON public.items(item_type);
CREATE INDEX idx_bills_customer ON public.bills(customer_name);
CREATE INDEX idx_bills_date ON public.bills(bill_date);
CREATE INDEX idx_bills_status ON public.bills(status);
CREATE INDEX idx_bill_items_bill ON public.bill_items(bill_id);
CREATE INDEX idx_customers_name ON public.customers(name);
CREATE INDEX idx_metal_prices_type ON public.metal_prices(metal_type);

-- Updated_at trigger function
CREATE OR REPLACE FUNCTION public.update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = now();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql SET search_path = public;

CREATE TRIGGER update_items_updated_at BEFORE UPDATE ON public.items FOR EACH ROW EXECUTE FUNCTION public.update_updated_at_column();
CREATE TRIGGER update_metal_prices_updated_at BEFORE UPDATE ON public.metal_prices FOR EACH ROW EXECUTE FUNCTION public.update_updated_at_column();
CREATE TRIGGER update_customers_updated_at BEFORE UPDATE ON public.customers FOR EACH ROW EXECUTE FUNCTION public.update_updated_at_column();
CREATE TRIGGER update_bills_updated_at BEFORE UPDATE ON public.bills FOR EACH ROW EXECUTE FUNCTION public.update_updated_at_column();
