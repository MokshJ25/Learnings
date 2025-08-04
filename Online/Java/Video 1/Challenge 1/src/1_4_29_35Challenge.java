//WAP to reverse digits of a number:

import java.util.Scanner;

class Challenge1_4_29_35
{
    public static void main(String[] args)
    {
        reverse();
    }


    public static void reverse()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num=input.nextInt();
        System.out.print("Reverse of "+num+" is: ");
        while(num>0)
        {
            int m=num%10;
            System.out.print(m);
            num=num/10;
        }
    }
}
