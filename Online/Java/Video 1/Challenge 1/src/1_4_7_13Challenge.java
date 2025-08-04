//WAP to calculate Compound Interest:

import java.util.Scanner;

class Challenge1_4_7_13
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Principal");
        float p=input.nextFloat();
        System.out.print("Enter Rate");
        float r=input.nextFloat();
        System.out.print("Enter Time(in years)");
        float t=input.nextFloat();

        double ci= p* Math.pow((1+r/100),t);

        System.out.println("Compound Interest is: "+ci);
    }
}
