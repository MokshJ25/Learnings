//WAP to convert the temperature from fahrenheit to celsius:

import java.util.Scanner;

class Challenge1_4_8_14
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the temperature in Fahrenheit");
        float f=input.nextFloat();

        float c=(f-32)*5/9;

        System.out.println("Your Temperature from F to C is: "+c+"C");
    }
}
