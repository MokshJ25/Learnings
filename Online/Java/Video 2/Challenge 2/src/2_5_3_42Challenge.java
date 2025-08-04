//WAP to find maximum and minimum in the array:

class Challenge2_5_3_42
{
    public static void main(String[] args)
    {
        int[] arr=TakeArrayInput.input1DArray();
        if (arr.length<=0)
        {
            System.out.println("Your array is EMPTY, we cant proceed further.");
        }
        else
        {
            int max = max(arr);
            int min = min(arr);
            System.out.println(max+" is the maximum value present in your array.");
            System.out.println(min+" is the minimum value present in your array.");
        }

    }


    public static int max(int[] array)
    {
        int maximum=array[0];
        int i=1;
        while(i<array.length)
        {
            if(maximum<array[i])
            {
                maximum=array[i];
            }
            i++;
        }
        return maximum;
    }
    public static int min(int[] array)
    {
        int minimum=Integer.MAX_VALUE; //MAX_VALUE is a func. on Integer class, which gives max. int. value possible
        int i=0;
        while(i<array.length)
        {
            if(minimum>array[i])
            {
                minimum=array[i];
            }
            i++;
        }
        return minimum;
    }
}
/*
OR, we can also write the function for min using same concept as of max:
min:

public static int min(int[] array)
    {
        int minimum=array[0];
        int i=1;
        while(i<array.length)
        {
            if (minimum > array[i])
            {
                minimum = array[i];
            }
            i++;
        }
        return minimum;
    }
 */