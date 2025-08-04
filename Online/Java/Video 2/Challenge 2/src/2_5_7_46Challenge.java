//WAP to check the array is Palindrome or not:

class Challenge2_5_7_46
{
    public static void main(String[] args)
    {
        int[] arr = TakeArrayInput.input1DArray();
        int[] revArr = reverseArray(arr);

        boolean isPal=isPalindrome(arr,revArr);
        if(isPal)
        {
            System.out.println("Given array is Palindrome");
        }
        else
        {
            System.out.println("Given array is NOT Palindrome");
        }
    }


    public static int[] reverseArray(int[] array)
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
    public static boolean isPalindrome(int[] array, int[] revArray)
    {
        int i=0;
        while(i<array.length)
        {
            if(array[i]!=revArray[i])
            {
                return false;
            }
            i++;
        }
        return true;
    }
}
