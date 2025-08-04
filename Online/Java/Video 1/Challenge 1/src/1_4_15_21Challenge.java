//WAP to perform bitwise AND operation:

import java.util.Scanner;

class Challenge1_4_15_21
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two numbers to apply bitwise AND:");
        int a=input.nextInt();
        int b=input.nextInt();

        int c=a&b;
        System.out.println("Answer is: "+c);
    }
}
