//Wap to check weather the number is armstrong number or not:
/* Armstrong number: Aisa number jiske number of digits ko seperate har digits pe power lagae or fir
unka aapas me sum kare to wahi number aae. ex.: 153: (1^3)+(5^3)+(3^3)=153, i.e. it is an Armstrong number */

import java.util.Scanner;

class Challenge1_4_31_37
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number to be checked: ");
        int a = input.nextInt();
        double ans=armstrong(a);
        if(ans==a)
        {
            System.out.println(a+" is an Armstrong number");
        }
        else
        {
            System.out.println(a+" is NOT an Armstrong number");
        }
    }


    public static double armstrong(int num)
    {
        double i=0;
        int digits=countDigits(num);
        System.out.println("Number of Digits in "+num+" is: "+digits);
        while(num>0)
        {
            int mod=num%10;
            double sum=Math.pow((mod),digits); /* Java doesnt support "^" for power,we have to use
                                                  Math.pow() {"power" function in "Math" library} to apply power */
            num=num/10;
            i=sum+i;
        }
        return i;
    }

    public static int countDigits(int num)
    {
        int noOfDigits=0;
        while(num>0)
        {
            noOfDigits++;
            num/=10;
        }
        return noOfDigits;
    }
}
