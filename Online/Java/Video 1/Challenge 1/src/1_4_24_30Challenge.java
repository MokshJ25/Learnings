//WAP to find factorial of the number:

import java.util.Scanner;

class Challenge1_4_24_30
{
    public static void main(String[] args)
    {
        factorial();
    }


    public static void factorial()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n=input.nextInt();

        if(n<2)
        {
            System.out.println("Answer is: 1");
        }
        else
        {
            long a=1;
            int i=2;
            while(i<=n)
            {
                a*=i;
                i++;
            }
            System.out.println("Answer is: "+a);
        }
    }
}
