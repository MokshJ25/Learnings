class PatternUsingLoop1_53_2
{
    public static void main(String[] args)
    {
        pattern();
    }

    public static void pattern()
    {
        System.out.println("We Will print star pattern using while loop:");
        int row=1;
        while(row<=5)
        {
            System.out.print("*");
            int i=1;
            while(i<row)
            {
                System.out.print(" *");
                i++;
            }
            System.out.println();
            row++;
        }
    }
}
