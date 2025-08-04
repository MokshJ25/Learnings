//WAP to calculate Area of a triangle:

import java.util.Scanner;

class Challenge1_4_5_11
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Base of the triangle: ");
        double b=input.nextDouble();
        System.out.print("Enter Height of the triangle: ");
        double h=input.nextDouble();

        double a=0.5*b*h;

        System.out.println("Area of your triangle is: "+a);
    }
}
