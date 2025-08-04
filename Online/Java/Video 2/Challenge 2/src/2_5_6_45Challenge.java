//WAP to reverse an array:

class Challenge2_5_6_45
{
    public static void main(String[] args)
    {
        int[] arr=TakeArrayInput.input1DArray();
        System.out.println("Your reversed Array is: ");
        int[] revArr=revArray(arr);
        DisplayArray.display1DArray(revArr);
    }


    public static int[] revArray(int[] array)
    {
        int[] newArr= new int[array.length];
        int i=array.length, j=0;
        while(j<array.length)
        {
            newArr[j]=array[i-1];
            i--;
            j++;
        }
        return newArr;
    }
}
