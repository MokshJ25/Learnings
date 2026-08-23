export type Json =
  | string
  | number
  | boolean
  | null
  | { [key: string]: Json | undefined }
  | Json[]

export type Database = {
  // Allows to automatically instantiate createClient with right options
  // instead of createClient<Database, { PostgrestVersion: 'XX' }>(URL, KEY)
  __InternalSupabase: {
    PostgrestVersion: "14.5"
  }
  public: {
    Tables: {
      bill_items: {
        Row: {
          bill_id: string
          created_at: string
          id: string
          item_id: string | null
          item_name: string
          price: number
          quantity: number
          selling_type: Database["public"]["Enums"]["selling_type"]
          total: number
          variant: string
          weight: number
        }
        Insert: {
          bill_id: string
          created_at?: string
          id?: string
          item_id?: string | null
          item_name: string
          price?: number
          quantity?: number
          selling_type?: Database["public"]["Enums"]["selling_type"]
          total?: number
          variant?: string
          weight?: number
        }
        Update: {
          bill_id?: string
          created_at?: string
          id?: string
          item_id?: string | null
          item_name?: string
          price?: number
          quantity?: number
          selling_type?: Database["public"]["Enums"]["selling_type"]
          total?: number
          variant?: string
          weight?: number
        }
        Relationships: [
          {
            foreignKeyName: "bill_items_bill_id_fkey"
            columns: ["bill_id"]
            isOneToOne: false
            referencedRelation: "bills"
            referencedColumns: ["id"]
          },
          {
            foreignKeyName: "bill_items_item_id_fkey"
            columns: ["item_id"]
            isOneToOne: false
            referencedRelation: "items"
            referencedColumns: ["id"]
          },
        ]
      }
      bills: {
        Row: {
          amount_paid: number
          bill_date: string
          bill_number: number
          created_at: string
          customer_name: string
          discount: number
          due_amount: number
          id: string
          status: string
          subtotal: number
          total: number
          updated_at: string
          village: string
        }
        Insert: {
          amount_paid?: number
          bill_date?: string
          bill_number?: number
          created_at?: string
          customer_name: string
          discount?: number
          due_amount?: number
          id?: string
          status?: string
          subtotal?: number
          total?: number
          updated_at?: string
          village?: string
        }
        Update: {
          amount_paid?: number
          bill_date?: string
          bill_number?: number
          created_at?: string
          customer_name?: string
          discount?: number
          due_amount?: number
          id?: string
          status?: string
          subtotal?: number
          total?: number
          updated_at?: string
          village?: string
        }
        Relationships: []
      }
      customers: {
        Row: {
          created_at: string
          id: string
          name: string
          phone: string
          total_due: number
          updated_at: string
          village: string
        }
        Insert: {
          created_at?: string
          id?: string
          name: string
          phone?: string
          total_due?: number
          updated_at?: string
          village?: string
        }
        Update: {
          created_at?: string
          id?: string
          name?: string
          phone?: string
          total_due?: number
          updated_at?: string
          village?: string
        }
        Relationships: []
      }
      items: {
        Row: {
          company: string
          created_at: string
          id: string
          item_name: string
          item_type: string
          low_stock_threshold: number
          metal_type: string
          price: number
          price_per_kg: number
          quantity: number
          selling_type: Database["public"]["Enums"]["selling_type"]
          updated_at: string
          variant: string
        }
        Insert: {
          company?: string
          created_at?: string
          id?: string
          item_name: string
          item_type?: string
          low_stock_threshold?: number
          metal_type?: string
          price?: number
          price_per_kg?: number
          quantity?: number
          selling_type?: Database["public"]["Enums"]["selling_type"]
          updated_at?: string
          variant?: string
        }
        Update: {
          company?: string
          created_at?: string
          id?: string
          item_name?: string
          item_type?: string
          low_stock_threshold?: number
          metal_type?: string
          price?: number
          price_per_kg?: number
          quantity?: number
          selling_type?: Database["public"]["Enums"]["selling_type"]
          updated_at?: string
          variant?: string
        }
        Relationships: []
      }
      metal_prices: {
        Row: {
          company: string
          created_at: string
          id: string
          metal_type: string
          price_per_kg: number
          updated_at: string
        }
        Insert: {
          company?: string
          created_at?: string
          id?: string
          metal_type: string
          price_per_kg?: number
          updated_at?: string
        }
        Update: {
          company?: string
          created_at?: string
          id?: string
          metal_type?: string
          price_per_kg?: number
          updated_at?: string
        }
        Relationships: []
      }
      payments: {
        Row: {
          amount: number
          bill_id: string
          created_at: string
          id: string
          notes: string
          payment_date: string
        }
        Insert: {
          amount?: number
          bill_id: string
          created_at?: string
          id?: string
          notes?: string
          payment_date?: string
        }
        Update: {
          amount?: number
          bill_id?: string
          created_at?: string
          id?: string
          notes?: string
          payment_date?: string
        }
        Relationships: [
          {
            foreignKeyName: "payments_bill_id_fkey"
            columns: ["bill_id"]
            isOneToOne: false
            referencedRelation: "bills"
            referencedColumns: ["id"]
          },
        ]
      }
      returns: {
        Row: {
          bill_id: string
          bill_item_id: string
          created_at: string
          id: string
          reason: string
          refund_amount: number
          return_quantity: number
          return_weight: number
        }
        Insert: {
          bill_id: string
          bill_item_id: string
          created_at?: string
          id?: string
          reason?: string
          refund_amount?: number
          return_quantity?: number
          return_weight?: number
        }
        Update: {
          bill_id?: string
          bill_item_id?: string
          created_at?: string
          id?: string
          reason?: string
          refund_amount?: number
          return_quantity?: number
          return_weight?: number
        }
        Relationships: [
          {
            foreignKeyName: "returns_bill_id_fkey"
            columns: ["bill_id"]
            isOneToOne: false
            referencedRelation: "bills"
            referencedColumns: ["id"]
          },
          {
            foreignKeyName: "returns_bill_item_id_fkey"
            columns: ["bill_item_id"]
            isOneToOne: false
            referencedRelation: "bill_items"
            referencedColumns: ["id"]
          },
        ]
      }
    }
    Views: {
      [_ in never]: never
    }
    Functions: {
      [_ in never]: never
    }
    Enums: {
      selling_type: "per_piece" | "per_weight"
    }
    CompositeTypes: {
      [_ in never]: never
    }
  }
}

type DatabaseWithoutInternals = Omit<Database, "__InternalSupabase">

type DefaultSchema = DatabaseWithoutInternals[Extract<keyof Database, "public">]

export type Tables<
  DefaultSchemaTableNameOrOptions extends
    | keyof (DefaultSchema["Tables"] & DefaultSchema["Views"])
    | { schema: keyof DatabaseWithoutInternals },
  TableName extends DefaultSchemaTableNameOrOptions extends {
    schema: keyof DatabaseWithoutInternals
  }
    ? keyof (DatabaseWithoutInternals[DefaultSchemaTableNameOrOptions["schema"]]["Tables"] &
        DatabaseWithoutInternals[DefaultSchemaTableNameOrOptions["schema"]]["Views"])
    : never = never,
> = DefaultSchemaTableNameOrOptions extends {
  schema: keyof DatabaseWithoutInternals
}
  ? (DatabaseWithoutInternals[DefaultSchemaTableNameOrOptions["schema"]]["Tables"] &
      DatabaseWithoutInternals[DefaultSchemaTableNameOrOptions["schema"]]["Views"])[TableName] extends {
      Row: infer R
    }
    ? R
    : never
  : DefaultSchemaTableNameOrOptions extends keyof (DefaultSchema["Tables"] &
        DefaultSchema["Views"])
    ? (DefaultSchema["Tables"] &
        DefaultSchema["Views"])[DefaultSchemaTableNameOrOptions] extends {
        Row: infer R
      }
      ? R
      : never
    : never

export type TablesInsert<
  DefaultSchemaTableNameOrOptions extends
    | keyof DefaultSchema["Tables"]
    | { schema: keyof DatabaseWithoutInternals },
  TableName extends DefaultSchemaTableNameOrOptions extends {
    schema: keyof DatabaseWithoutInternals
  }
    ? keyof DatabaseWithoutInternals[DefaultSchemaTableNameOrOptions["schema"]]["Tables"]
    : never = never,
> = DefaultSchemaTableNameOrOptions extends {
  schema: keyof DatabaseWithoutInternals
}
  ? DatabaseWithoutInternals[DefaultSchemaTableNameOrOptions["schema"]]["Tables"][TableName] extends {
      Insert: infer I
    }
    ? I
    : never
  : DefaultSchemaTableNameOrOptions extends keyof DefaultSchema["Tables"]
    ? DefaultSchema["Tables"][DefaultSchemaTableNameOrOptions] extends {
        Insert: infer I
      }
      ? I
      : never
    : never

export type TablesUpdate<
  DefaultSchemaTableNameOrOptions extends
    | keyof DefaultSchema["Tables"]
    | { schema: keyof DatabaseWithoutInternals },
  TableName extends DefaultSchemaTableNameOrOptions extends {
    schema: keyof DatabaseWithoutInternals
  }
    ? keyof DatabaseWithoutInternals[DefaultSchemaTableNameOrOptions["schema"]]["Tables"]
    : never = never,
> = DefaultSchemaTableNameOrOptions extends {
  schema: keyof DatabaseWithoutInternals
}
  ? DatabaseWithoutInternals[DefaultSchemaTableNameOrOptions["schema"]]["Tables"][TableName] extends {
      Update: infer U
    }
    ? U
    : never
  : DefaultSchemaTableNameOrOptions extends keyof DefaultSchema["Tables"]
    ? DefaultSchema["Tables"][DefaultSchemaTableNameOrOptions] extends {
        Update: infer U
      }
      ? U
      : never
    : never

export type Enums<
  DefaultSchemaEnumNameOrOptions extends
    | keyof DefaultSchema["Enums"]
    | { schema: keyof DatabaseWithoutInternals },
  EnumName extends DefaultSchemaEnumNameOrOptions extends {
    schema: keyof DatabaseWithoutInternals
  }
    ? keyof DatabaseWithoutInternals[DefaultSchemaEnumNameOrOptions["schema"]]["Enums"]
    : never = never,
> = DefaultSchemaEnumNameOrOptions extends {
  schema: keyof DatabaseWithoutInternals
}
  ? DatabaseWithoutInternals[DefaultSchemaEnumNameOrOptions["schema"]]["Enums"][EnumName]
  : DefaultSchemaEnumNameOrOptions extends keyof DefaultSchema["Enums"]
    ? DefaultSchema["Enums"][DefaultSchemaEnumNameOrOptions]
    : never

export type CompositeTypes<
  PublicCompositeTypeNameOrOptions extends
    | keyof DefaultSchema["CompositeTypes"]
    | { schema: keyof DatabaseWithoutInternals },
  CompositeTypeName extends PublicCompositeTypeNameOrOptions extends {
    schema: keyof DatabaseWithoutInternals
  }
    ? keyof DatabaseWithoutInternals[PublicCompositeTypeNameOrOptions["schema"]]["CompositeTypes"]
    : never = never,
> = PublicCompositeTypeNameOrOptions extends {
  schema: keyof DatabaseWithoutInternals
}
  ? DatabaseWithoutInternals[PublicCompositeTypeNameOrOptions["schema"]]["CompositeTypes"][CompositeTypeName]
  : PublicCompositeTypeNameOrOptions extends keyof DefaultSchema["CompositeTypes"]
    ? DefaultSchema["CompositeTypes"][PublicCompositeTypeNameOrOptions]
    : never

export const Constants = {
  public: {
    Enums: {
      selling_type: ["per_piece", "per_weight"],
    },
  },
} as const
