//WAP to calculate Simple Interest:

import java.util.Scanner;

class Challenge1_4_6_12
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Principle: ");
        float p=input.nextFloat();
        System.out.print("Enter Rate: ");
        float r=input.nextFloat();
        System.out.print("Enter Time(in years): ");
        float t=input.nextFloat();

        float si= (p*r*t)/100;

        System.out.println("Simple Interest is: "+si);
    }
}
