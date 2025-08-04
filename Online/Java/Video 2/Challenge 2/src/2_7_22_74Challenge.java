//WAP as a number guessing game where program selects a random number and user has to guess:

import java.util.Scanner;

class Challenge2_7_22_74
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int num=-1;
        int generated =guess();

        do
        {
        System.out.print("Enter the number between 0 to 10: ");
        num = input.nextInt();
        }while(num!=generated);
        System.out.print("your guess: "+num+"\nOur Guess: "+generated);
    }

    public static int guess()
    {
        return (int) (Math.random() * 11);
    }
}
