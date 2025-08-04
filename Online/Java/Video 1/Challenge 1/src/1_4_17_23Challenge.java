//WAP to perform XOR operation:

import java.util.Scanner;

class Challenge1_4_17_23
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two numbers to perform XOR operations");
        int a=input.nextInt();
        int b=input.nextInt();
        int c=a^b;

        System.out.println("Answer is: "+c);
    }

}
