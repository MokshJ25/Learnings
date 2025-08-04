//WAP to calculate absolute value of an integer:

import java.util.Scanner;

class Challenge2_7_3_55
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num=input.nextInt();

        int ans = num<0 ? -num : num;
        System.out.println("Absolute value of "+num+" is: "+ans);
    }
}
