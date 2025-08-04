//WAP to perform bitwise OR operation:

import java.util.Scanner;

class Challenge1_4_16_22
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two number to show bitwise OR operation: ");
        int a = input.nextInt();
        int b=input.nextInt();
        int c=a|b;

        System.out.println("Answer is: "+c);
    }
}
