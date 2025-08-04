class TypeConversion1_38_1
{
    public static void main(String[] args)
    {
        System.out.println("Implicit:");
        float a=5;
        System.out.println("a="+a);
        float b=5L;
        System.out.println("b="+b);

        System.out.println("Explicit:");
        int c=(int)5.5;
        System.out.println("c="+c);
        long d=(long )5.45f;
        System.out.println("d="+d);
    }
}
