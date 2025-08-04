class BreakAndContinue
{
    public static void main(String[] args)
    {
        breakDemo();
        continueDemo();
    }
    public static void breakDemo()
    {
        System.out.println("Executing Break statement:");
        System.out.println("Before loop");
        for(int i=1;i<1000;i++)
        {
            if(i==101)
            {
                break;
            }
            System.out.print(i+"\t");
        }
        System.out.println("\nOut of loop");
    }
    public static void continueDemo()
    {
        System.out.println("Executing Continue statement:");
        System.out.println("Before loop");
        for(int i=1;i<10;i++)
        {
            if(i==5)
            {
                continue; /* jaise hi continue encounter hoga waise hi bina baad ki chize execute kie compiler for
                             loop ke update wale part me jaega(loop ka next round chalaega), variable update hoga,
                             fir condiition check hogi, fir loop me ghusega(obviously).
                             to yaha "5" print nahi hoga kyuki "i" jaise hi 5 hoga, "if" wali condition true ho
                             jaegi, "continue" encounter hoga, flow wapis "for" loop ke update wale part me chale
                             jaega, i.e., "i++" or aage fir condition check hogi or loop wapis chalega(obviously).
                             in simple words, "continue" loop ke ek current iteration ko skip karne me kaam aata hai*/
            }
            System.out.print(i+"\t");
        }
        System.out.println("\nOut of loop");
    }
}
