//WAP to calculate product of two decimal numbers:

import java.util.Scanner;

class Challenge1_4_3_9
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first floating point number: ");
        double a=input.nextDouble();
        System.out.print("Enter Second floating point number: ");
        double b=input.nextDouble();

        double c=a*b;

        System.out.print("Product of two floating point numbers is: "+c);
    }
}
