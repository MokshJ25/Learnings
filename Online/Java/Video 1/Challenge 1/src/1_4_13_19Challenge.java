//WAP to find the grades:

import java.util.Scanner;

class Challenge1_4_13_19
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your grades: ");
        float a=input.nextFloat();

        if(a>=90)
        {
            System.out.println("You have got A");
        }
        else if(a>=75)
        {
            System.out.println("You have got B");
        }
        else if(a>60)
        {
            System.out.println("You have got C");
        }
        else if(a>=30)
        {
            System.out.println("You have got D");
        }
        else if(a<30)
        {
            System.out.println("You have got F");
        }
        else
        {
            System.out.println("Enter Valid Grades");
        }




        /* The code can also be written as: (without using "else if")
        if(a<30&&a>0)
        {
            System.out.println("You have got F");
        }
        if(a<60&&a>=30)
        {
            System.out.println("You have got D");
        }
        if(a<75&&a>=60)
        {
            System.out.println("You have got C");
        }
        if(a<90&&a>=75)
        {
            System.out.println("You have got B");
        }
        if(a<100&&a>=90)
        {
            System.out.println("You have got A");
        }
        else
        {
            System.out.println("Enter Valid Grades");
        }
        */
    }
}
