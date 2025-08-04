//WAP to categorise students based on their Scores:

import java.util.Scanner;

class Challenge2_7_4_56
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the score: ");
        int score=input.nextInt();

        String ans= (score>49 && score>=0) ? ((score>80 && score<=100) ? "High" : "Moderate") : "Low";
        System.out.println("Student falls under "+ans);
    }
}
