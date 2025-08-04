package in2_8.Challenge2_8_6_82;

public class Tester2_8_6_82
{
    public static void main(String[] args)
    {
        ArrayOperations opr = new ArrayOperations(new int[]{1,3,5,9});
        ArrayOperations.Statistics stats = opr.new Statistics();

        System.out.println("Mean is: "+stats.mean());
    }
}
