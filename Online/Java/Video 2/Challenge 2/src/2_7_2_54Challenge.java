// WAP to find given number is even or odd

import java.util.Scanner;

class Challenge2_7_2_54
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num=input.nextInt();

        Challenge2_7_2_54 obj1=new Challenge2_7_2_54();
        String ans = obj1.evenOdd(num);
        System.out.println(num+" is "+ans);
    }
    public String evenOdd(int a)
    {
        String ans= a%2==0 ? "Even" : "Odd";
        return ans;
    }
}
