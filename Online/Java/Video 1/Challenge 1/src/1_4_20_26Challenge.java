//WAP to perform right shift:

import java.util.Scanner;

class Challenge1_4_20_26
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number to perform Right shift: ");
        int a=input.nextInt();

        int b=a>>1;
        System.out.println("Answer is: "+b);
    }
}
