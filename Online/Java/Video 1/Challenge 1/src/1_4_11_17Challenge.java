//WAP to find greater among three numbers:

import java.util.Scanner;

class Challenge1_4_11_17
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the three numbers: ");
        int a=input.nextInt();
        int b=input.nextInt();
        int c=input.nextInt();

        if(a>b&&a>c)
        {
            System.out.println(a+" is greater");
        }
        else if(b>a&&b>c)
        {
            System.out.println(b+" is greater");
        }
        else
        {
            System.out.println(c+" is greater");
        }
    }
}
