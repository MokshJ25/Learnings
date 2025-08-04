//WAP to check whether the given array is sorted or not:

class Challenge2_5_4_43
{
    public static void main(String[] args)
    {
        int[] arr = TakeArrayInput.input1DArray();
        boolean answer1 = increasingOrder(arr);
        boolean answer2 = decreasingOrder(arr);

        if(answer1 || answer2)
        {
            System.out.println("Your entered array is in sorted order.");
        }
        else
        {
            System.out.println("Your entered array is not sorted.");
        }
    }

    public static boolean increasingOrder(int[] array)
    {
        int first = array[0];
        int start = 1;
        int i = 1;

        while(start < array.length)
        {
            if(first <= array[i])
            {
                first = array[i];
                i++;
            }
            else
            {
                return false;
            }
            start++;
        }
        return true;
    }

    public static boolean decreasingOrder(int[] array)
    {
        int first = array[0];
        int start = 1;
        int i = 1;

        while(start < array.length)
        {
            if(first >= array[i])
            {
                first = array[i];
                i++;
            }
            else
            {
                return false;
            }
            start++;
        }
        return true;
    }
}
