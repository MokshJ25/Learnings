//WAP to delete specific elements from the array:

import java.util.Scanner;

class Challenge2_5_5_44
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int[] arr=TakeArrayInput.input1DArray();
        System.out.print("Enter the number you want to delete: ");
        int a=input.nextInt();
        int occ=occ(arr,a);
        System.out.println("Your entered array is:");
        DisplayArray.display1DArray(arr);
        System.out.println(a+" is occurring "+occ+" times in your array.");

        //Now, creating new array excluding deleted element:
        int[] newArr=new int[arr.length-occ];
        newArr=newArray(arr,a,newArr.length);
        if (occ==arr.length)
        {
            System.out.println("Whole array is deleted");
        }
        else
        {
            System.out.println("Your new array Excluding "+a+" is:");
            DisplayArray.display1DArray(newArr);
        }
    }


    public static int occ(int[] array, int num)
    {
        int i=0;
        int count=0;
        while(i<array.length)
        {
            if(array[i]==num)
            {
                count++;
            }
            i++;
        }
        return count;
    }
    public static int[] newArray(int[] array,int num,int occur)
    {
        int[] newArr =new int[occur];
        if (occur==0)
        {
            return array;
        }
        System.out.println("Remaining number of elements in the array is: "+newArr.length);
        int i=0, j=0;
        while(i<array.length)
        {
            if(array[i]!=num)
            {
                newArr[j]=array[i];
                j++;
            }
            i++;
        }
        return newArr;
        //return DisplayArray.display1DArray(newArr);
    }
}
