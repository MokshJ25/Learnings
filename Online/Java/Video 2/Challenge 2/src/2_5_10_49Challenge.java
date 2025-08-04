//WAP to do sum and average of a 2D array:

class Challenge2_5_10_49
{
    public static void main(String[] args)
    {
        int[][] arr=TakeArrayInput.input2DArray();
        float avg=average(arr);
        if(arr.length<=0)
        {
            System.out.println("The array is empty");
        }
        else
        {
            System.out.println("Average is: " + avg);
        }
    }


    public static float average(int[][] array)
    {
        int i=0, temp=0, total=0;
        while(i<array.length)
        {
            int j=0;
            while(j<array[i].length)
            {
                temp+=array[i][j];
                j++;
                total++;
            }
            i++;
        }
        System.out.println("total elements are: "+total);
        System.out.println("Sum of the elements is: "+temp);
        return ((float) temp /total); /*Explicitly type casted one number to "float", because "temp"
        and "total", both are integers, and their division will also give the answer in integer.
        any one of the two numbers must be a floating point number(flloat or double) in order to get
        answer in decimals.*/
    }
}
