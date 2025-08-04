//WAP to add two numbers:

import java.util.Scanner;

class Challenge1_3_3_6
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner (System.in);
        System.out.print("Enter 1st number: ");
        int a=input.nextInt();
        System.out.print("Enter 2nd number: ");
        int b=input.nextInt();

        System.out.println("Your sum is: "+(a+b));
    }
}
