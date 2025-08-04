//WAP to check weather the number is positive, negative or equal to 0:

import java.util.Scanner;

class Challenge1_4_9_15
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number to be checked: ");
        int a=input.nextInt();

        if(a>0)
        {
            System.out.println(a+" is positive");
        }
        else if(a<0)
        {
            System.out.println(a+" is negative");
        }
        else
        {
            System.out.println(a+" is equal to 0");
        }
    }
}
