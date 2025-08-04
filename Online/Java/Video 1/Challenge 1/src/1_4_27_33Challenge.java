//WAP to find Greatest Common Divisor(GCD) of two numbers:
//GCD: Greatest Common Divisor: sabse bada number jo dono numbers ko divide karta hai. ex.: 5 in the case of 15 and 20

import java.util.Scanner;

class Challenge1_4_27_33
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a=input.nextInt();
        System.out.print("Enter Second number: ");
        int b=input.nextInt();
        int gcd= greatestCommonDivisor(a,b);
        System.out.println("Greatest Common Divisor for "+a+" and "+b+" is: "+gcd);
    }


    public static int greatestCommonDivisor(int first, int second)
    {
        int least=leastNumber(first, second);
        int num=1;
        int i=least;
        while (i>=2)
        {
            if(first%i==0 && second%i==0)
            {
                return i;
            }
            i--;
        }
        return num;
    }

    public static int leastNumber(int first, int second)
    {
        int least;
        if(first<second)
        {
            least=first;
        }
        else
        {
            least=second;
        }
        return least;
    }
}
