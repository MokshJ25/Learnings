//WAP to check weather the year is leap pr not:

import java.util.Scanner;

class Challenge1_4_12_18
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the year to be checked: ");
        int a=input.nextInt();

        if(a%400==0 || (a%4==0 && a%100!=0))
        {
            System.out.println(a+" is a Leap year");
        }
        else
        {
            System.out.println(a+" is not a leap year");
        }
    }
}
