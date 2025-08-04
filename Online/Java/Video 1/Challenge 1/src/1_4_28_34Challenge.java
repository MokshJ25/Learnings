//WAP to check weather the number is prime or not:

import java.util.Scanner;

class Challenge1_4_28_34
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=input.nextInt();
        boolean num=isPrime(a);
        if (num)
        {
            System.out.println(a+" is a prime number");
        }
        else
        {
            System.out.println(a+" is NOT a prime number");
        }
    }


    public static boolean isPrime(int a)
    {
        int i=2;
        while(i<a)
        {
            if(a%i==0)
            {
                return false;
            }
            i++;
        }
        return true;
    }
}
