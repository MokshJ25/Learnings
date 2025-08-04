package in2_8.Challenge2_8_6_82;

public class ArrayOperations
{
    private int[] arr;

    public ArrayOperations(int[] arr)
    {
        this.arr = arr;
    }

    public class Statistics
    {
        double mean()
        {
            double sum=0;
            for (int i : arr)
            {
                sum+=i;
            }
            return sum/arr.length;
        }
        void median()
        {
            System.out.println("we will write code for median later");
        }
    }
}
