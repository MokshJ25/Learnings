//WAP to give occurence of an element in an array using for each loop

import java.util.Scanner;

class Challenge2_7_12_64
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] arr=TakeArrayInput.input1DArray();
        System.out.print("Enter the number whose occurrence you want to find: ");
        int num = input.nextInt();

        int i=0;
        for( int temp:arr)
        {
            if(temp==num)
            {
                i++;
            }
        }
        System.out.print(num+" is occurring "+i+" times");
    }
}
