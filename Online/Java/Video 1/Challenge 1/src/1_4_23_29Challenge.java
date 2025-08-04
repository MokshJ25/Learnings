//WAP to find Sum of odd number:

import java.util.Scanner;

class Challenge1_4_23_29
{
    public static void main(String[] args)
    {
        sumOfOdd();
    }


    public static void sumOfOdd()
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the limit number: ");
        int n=input.nextInt();
        int a=0;
        int i=1;

        while(i<=n)
        {
            while(i%2!=0)
            {
                a=a+i;
                i++;
            }
            i++;
        }
        System.out.println("Sum is: "+a);
    }
}
