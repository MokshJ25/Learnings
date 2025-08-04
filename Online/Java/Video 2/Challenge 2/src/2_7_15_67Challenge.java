//WAP to print only even, skipping odd using continue

class Challenge2_7_15_67
{
    public static void main(String[] args)
    {
        int[] arr = TakeArrayInput.input1DArray();

        System.out.println("\nEven numbers are: ");
        for (int temp : arr)
        {
            if (temp % 2 != 0)
            {
                continue;
            }
            System.out.println(temp);
        }
    }
}
