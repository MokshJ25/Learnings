//WAP to find correct age group:

import java.util.Scanner;

class Challenge1_4_14_20
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Age: ");
        int a=input.nextInt();

        if(a>=60)
        {
            System.out.println("You are a SENIOR");
        }
        else if(a>=20)
        {
            System.out.println("You are a ADULT");
        }
        else if(a>=13)
        {
            System.out.println("You are an TEEN");
        }
        else if(a<13)
        {
            System.out.println("You are a CHILD");
        }
        else
        {
            System.out.println("Enter a Valid Age");
        }


        /* The code can also be written as: (without using "else if")
        if(a<13&&a>0)
        {
            System.out.println("You are a CHILD");
        }
        if(a<20&&a>=13)
        {
            System.out.println("You are a TEEN");
        }
        if(a<60&&a>=20)
        {
            System.out.println("You are an ADULT");
        }
        if(a>=60)
        {
            System.out.println("You are a SENIOR");
        }
        else
        {
            System.out.println("Enter a Valid Age");
        }
        */
    }
}
