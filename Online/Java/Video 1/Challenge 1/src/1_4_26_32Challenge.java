//WAP to find Least Common Multiple(LCM) of two numbers:
//LCM: Least Common Multiple: sabse chhota number jo dono numbers se divide hota hai. ex.: 60 in the case of 15 and 20

import  java.util.Scanner;

class Challenge1_4_26_32
{
    public static void main(String[] args)
    {
        lcm();
    }


    public static void lcm()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two numbers to find the LCM: ");
        int a=input.nextInt();
        int b=input.nextInt();

        int i=1;
        while(i<=b)
        {
            int temp=a*i;
            if(temp%b==0)
            {
                System.out.println("LCM of "+a+" and "+b+" is: "+temp);
                break;
            }
            i++;
        }
    }
}
 /*
            if(a%i==0 && b%i==0)
            {
                System.out.println("LCM of "+a+" and "+b+" is: "+i);
            }
            i++;
             */