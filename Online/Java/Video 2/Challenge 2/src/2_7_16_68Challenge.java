//WAP to print fibonacci eries using recursion

import java.util.Scanner;

class Challenge2_7_16_68
{
    static long a=0,b=1;

    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter number of elements you want in your series: ");
        int ele=input.nextInt();

        System.out.print("Fibonacci Series: "+a+" "+b+" ");
        fibonacci(ele-2);
    }

    public static void fibonacci(int elements)
    {
        if(elements>0)
        {
            long next =a+b;
            System.out.print(next+" ");
            a=b;
            b=next;
            fibonacci(elements-1);
        }
    }
}

/*
ANOTHER LOGIC:
//WAP to print fibonacci eries using recursion

import java.util.Scanner;

class Challenge2_7_16_68
{
    static long a=0,b=1;

    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter number of elements you want in your series: ");
        int ele=input.nextInt();

        for(int i=1;i<=ele;i++)
        {
            System.out.println(fibonacci(i)+" ");
        }
    }

    public static int fibonacci(int elements)
    {
        if(elements==1)
        {
            return 0;
        }
        if(elements==2)
        {
            return 1;
        }
        return fibonacci(elements - 1) + fibonacci(elements-2);
    }
}
*/