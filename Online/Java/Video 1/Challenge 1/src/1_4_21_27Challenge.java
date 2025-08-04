//WAP to check weather the number is even or odd:

import java.sql.SQLOutput;
import java.util.Scanner;

class Challenge1_4_21_27
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=input.nextInt();

        if((a&1)==0)
        {
            System.out.println(a+" is EVEN");
        }
        else
        {
            System.out.println(a+" is ODD");
        }

    }
}
