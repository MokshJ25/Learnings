//WAP to make a basic Calculator:

import java.util.Scanner;

class Challenge1_4_2_8
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First number: ");
        int a=input.nextInt();
        System.out.print("Enter Second number: ");
        int b=input.nextInt();

        System.out.println("Addition(+) : "+(a+b));
        System.out.println("Subtraction(-) : "+(a-b));
        System.out.println("Multiplication(*) : "+(a*b));
        System.out.println("Division(/) : "+(a/b));
        System.out.println("Modulus(%) : "+(a%b));

    }
}
