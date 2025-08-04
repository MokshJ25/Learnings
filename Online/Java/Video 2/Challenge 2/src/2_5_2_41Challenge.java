//WAP to find number od Occurrences of an element in an array:

import java.util.Scanner;

class Challenge2_5_2_41
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int[] arr= TakeArrayInput.input1DArray();
        System.out.print("Enter the number: ");
        int num=input.nextInt();

        int occurrence=occ(num,arr);
        if(occurrence>0)
        {
            System.out.println(num + " is occurring " + occurrence + " times in your array.");
        }
        else
        {
            System.out.println(num + " is not in your array.");
        }
    }


    public static int occ(int a, int[] array)
    {
        int j=0;
        int i=0;
        while(i<array.length)
        {
            if(a==array[i])
            {
                j++;
            }
            i++;
        }
        return j;
    }
}
