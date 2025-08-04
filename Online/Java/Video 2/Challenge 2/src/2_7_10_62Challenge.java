//WAP to check prime number using for loop

import java.util.Scanner;

class Challenge2_7_10_62
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = input.nextInt();
        System.out.println("Your number is " +(isPrime(num) ? "Prime" : "not Prime"));
    }

    public static boolean isPrime(int num)
    {
        for(int i=2;i<num;i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }
        return true;
    }
}
