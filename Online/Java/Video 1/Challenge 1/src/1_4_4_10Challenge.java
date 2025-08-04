//WAP to calculate area of a rectangle:

import java.util.Scanner;

class Challenge1_4_4_10
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 4 sides of the rectangle: ");
        double a=input.nextDouble();
        double b=input.nextDouble();
        double c=input.nextDouble();
        double d=input.nextDouble();

        System.out.println("Perimeter of the rectangle ABCD is: "+(a+b+c+d));
    }
}