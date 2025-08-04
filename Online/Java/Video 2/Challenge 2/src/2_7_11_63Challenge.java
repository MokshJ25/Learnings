//WAP to find maximum value in an array using for each:

class Challenge2_7_11_63
{
    public static void main(String[] args)
    {
        int[] arr=TakeArrayInput.input1DArray();

        int max=Integer.MIN_VALUE;
        for(int num:arr)
        {
            if(max<num)
            {
                max=num;
            }
        }
        System.out.print("Maximum number is: "+max);
    }
}
