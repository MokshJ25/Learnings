//WAP tp verify the given number is palindrome or not
//Palindrome number: aisa number jiska reverse bhi wahi number ho

import java.util.Scanner;

class Challenge1_4_32_38
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number to be checked: ");
        int a= input.nextInt();
        int ans=palindrome(a);
        if(a==ans)
        {
            System.out.println(a+" is a palindrome");
        }
        else
        {
            System.out.println(a+" is NOT a palindrome");
        }
    }


    public static int palindrome(int num)
    {
        int extra=0;
        while(num>0)
        {
            int m=num%10;
            extra=((extra*10)+m);
            num/=10;
        }
        return extra;
    }
}
