//WAP to create simple calculator

import java.util.Scanner;

class Challenge2_7_6_58
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter First number");
        int num1=input.nextInt();
        System.out.println("Enter Second number");
        int num2=input.nextInt();
        System.out.print("Enter \"+\" for addition \nEnter\"-\" for subtraction \nEnter \"*\" for " +
                "multiplication \nEnter \"/\" for division \nEnter which operation you want to perform: ");
        String op=input.next();

        Challenge2_7_6_58 obj1=new Challenge2_7_6_58();
        float answer=obj1.calc(op, num1, num2);
        System.out.println("Answer is: "+answer);
    }

    public float calc(String ope, int a, int b)
    {
        return switch(ope)
        {
            case "+" -> a+b;
            case "-" -> a-b;
            case "*" -> a*b;
            case "/" -> (float)a/b;
            default ->00000;
        };
    }
}
