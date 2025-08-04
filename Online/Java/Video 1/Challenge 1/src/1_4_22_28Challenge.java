//WAP to show table of the number:

import java.util.Scanner;

class Challenge1_4_22_28
{
    public static void main(String[] args)
    {
        table();
    }


    public static void table()
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = input.nextInt();
        int i=1;
        while(i<=10)
        {
            System.out.println(a*i);
            i++;
        }
    }
}
