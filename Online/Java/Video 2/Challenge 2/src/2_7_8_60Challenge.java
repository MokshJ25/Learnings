// WAP to implement number guessing game using do while loop:

import java.util.Scanner;

class Challenge2_7_8_60
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int num=5;
        int guess;
        do
        {
            System.out.print("Enter the number between 0 to 10: ");
            guess =input.nextInt();
        } while(guess != num);
        System.out.println(guess +"! you guessed right!");
    }
}
