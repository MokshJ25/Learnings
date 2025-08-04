// WAP to print table of a number using for loop:

import com.sun.source.doctree.SinceTree;

import java.util.Scanner;

class Challenge2_7_9_61
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num=input.nextInt();
        int temp;

        System.out.println("Table of "+num+" is:");
        for(int i=1;i<=10;i++)
        {
            temp=num*i;
            System.out.println(temp);
        }
    }
}
