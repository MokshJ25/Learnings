//WAP to perform bitwise complement:

import java.util.Scanner;

class Challenge1_4_18_24
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number to apply bitwise complement: ");
        int a=input.nextInt();

        int b=~a;
        System.out.println("Answer is: "+b);
    }
}
