//WAP to search an element in 2D array

import java.util.Scanner;

class Challenge2_5_9_48
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int[][] arr=TakeArrayInput.input2DArray();
        System.out.print("Enter the element you want to search: ");
        int num=input.nextInt();

        boolean answer=(searching(arr, num));
        if(answer)
        {
            System.out.println(num+" is present in your array.");
        }
        else
        {
            System.out.println(num+" is NOT present in your array.");
        }
    }


    public static boolean searching(int[][] array, int ele)
    {
        int i=0;
        while(i<array.length)
        {
            int j=0;
            while(j<array[i].length)
            {
                if(array[i][j]==ele)
                {
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }
}
