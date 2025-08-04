//WAP to check weather the number is even or odd:

import java.util.Scanner;

class Challenge1_4_10_16
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number to be checked");
        int a= input.nextInt();

        if(a%2==0)
        {
            System.out.println("The number is EVEN");
        }
        else
        {
            System.out.println("The number is ODD");
        }
    }
}
