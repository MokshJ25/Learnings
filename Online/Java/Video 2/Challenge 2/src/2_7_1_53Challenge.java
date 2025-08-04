// WAP to find the minimum of two numbers:

import java.util.Scanner;

class Challenge2_7_1_53
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = input.nextInt();
        System.out.print("Enter Second number: ");
        int num2 = input.nextInt();

        Challenge2_7_1_53 obj1 =new Challenge2_7_1_53();
        int min=obj1.minimum(num1, num2);
        System.out.println(min+" is the smallest among "+num1+" and "+num2);

    }

    public int minimum(int num1, int num2)
    {
        return num1<num2 ? num1 : num2;
    }
}
