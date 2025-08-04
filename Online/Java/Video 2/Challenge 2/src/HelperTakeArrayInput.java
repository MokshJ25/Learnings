/*
In "Challenge2_5_34_40" or "2_5_34_40Challenge" we have done a new thing. We have made a separate Java
class file called "HelperTakeArrayInput.java" or "TakeArrayInput", which will facilitate us not to write
the code again and again to take input from our array. In the helper file, instead of writing
"public static void main(String[] args)", we have written "public static int[] function_name()" and then
in the function, rest of our code. The "static" will help us to call this function, present in different files,
by using the class_name and the function_name. After making "HelperTakeArrayInput" file this way, we can call
this array in "2_5_34_40Challenge" by declaring type, creating variable to store the array and calling
class_name.function_name, i.e., in "Challenge2_5_34_40" or "2_5_34_40Challenge" we have done it like:
"int[] array = TakeArrayInput.InputArray()"
{TakeArrayInput: Class name of the helper file
 input1DArray:     function name of the helper file which will be taking inputs.)}
 */

import java.util.Scanner;

class TakeArrayInput
{
    public static int[] input1DArray()
    {
        Scanner input=new Scanner(System.in);
        System.out.print("How many elements you want in your array?\n=> ");
        int size =input.nextInt();
        int[] arr= new int[size];
        System.out.println("Enter "+ size +" numbers: ");

        if(size<=0)
        {
            System.out.println("YOUR ARRAY IS EMPTY");
        }
        else
        {
            int i = 0;
            while (i < size)
            {
                arr[i] = input.nextInt();
                i++;
            }
        }
        return arr;
    }

    public static int[][] input2DArray()
    {
        Scanner input=new Scanner(System.in);
        System.out.print("How many rows?\n=> ");
        int rows =input.nextInt();
        System.out.print("How many columns?\n=> ");
        int columns =input.nextInt();
        int[][] arr= new int[rows][columns];
        System.out.println("Enter elements in your "+rows+"x"+columns+" array: ");

        int i = 0;
        while (i < rows)
        {
            int j=0;
            while(j<columns)
            {
                System.out.print("Enter element on "+(i+1)+"x"+(j+1)+" position: ");
                arr[i][j] = input.nextInt();
                j++;
            }
            i++;
            System.out.println();
        }
        return arr;
    }
}

