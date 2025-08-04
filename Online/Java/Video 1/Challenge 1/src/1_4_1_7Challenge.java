//WAP to Swap two numbers:

import java.util.Scanner;

class Challenge1_4_1_7
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int c=0;
        System.out.print("Enter 1st number : ");
        int a=input.nextInt();
        System.out.print("Enter 2nd number : ");
        int b=input.nextInt();

        System.out.println("Before Swapping:");
        System.out.println("a="+a+"\nb="+b);
        c=a;
        a=b;
        b=c;

        System.out.println("After Swapping: ");
        System.out.println("a="+a+"\nb="+b);
    }
}
