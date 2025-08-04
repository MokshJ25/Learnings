//WAP to print fibonacci series:

import java.util.Scanner;

class Challenge1_4_30_36
{
    public static void main(String[] args)
    {
        fibonacci();
    }


    public static void fibonacci()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers you want in the series?: ");
        int a=input.nextInt();
        int first=0;
        int second=1;
        if(a==1)
        {
            System.out.println(first);
        }
        else if(a==2)
        {
            System.out.println(first+", "+second);
        }
        else if(a>2)
        {
            System.out.print(first + ", " + second);
            int i = 2;
            while (i < a)
            {
                int sum = first + second;
                first = second;
                second = sum;
                System.out.print(", " + sum);
                i++;
            }
        }
    }
}
