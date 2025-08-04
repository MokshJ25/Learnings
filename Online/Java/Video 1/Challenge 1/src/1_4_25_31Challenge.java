//WAP to find Sum of Digits of the number:

import java.util.Scanner;

class Challenge1_4_25_31
{
    public static void main(String[] args)
    {
        sumOfDigit();
    }


    public static void sumOfDigit()
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num=input.nextInt();
        int sum=0;
        int d=num;

        if(num<10)
        {
            System.out.println("Sum of hte digits of "+num+" is "+num);
        }
        else
        {
            while(num>0)
            {
                int mod=num%10;
                num=num/10;
                sum+=mod;
                /*
                the code can also be written as:
                sum = sum + num %10;
                num = mum/10;
                System.out/println(sum);
                 */
            }
            System.out.println("Sum of digits of "+d+" is "+sum);
        }
    }
}
