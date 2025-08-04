//WAP to sum all positive integers using continue

class Challenge2_7_14_66
{
    public static void main(String[] args)
    {
        int[] arr=TakeArrayInput.input1DArray();
        int sum=0;

        for(int temp:arr)
        {
            if(temp<0)
            {
                continue;
            }
            sum+=temp;
        }
        System.out.print("Sum of entered numbers is: "+sum);
    }
}
