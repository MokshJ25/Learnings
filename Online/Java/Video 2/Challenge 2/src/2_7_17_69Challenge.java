//WAP to check if a string is palindrome using recursion:

import java.util.Scanner;

class Challenge2_7_17_69
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string to be checked: ");
        String str=input.next();

        System.out.print(str+" is "+(isPalindrome(str) ? "Palindrome" : "NOT Palindrome"));

    }

    public static boolean isPalindrome(String str)
    {
        int lastPos=str.length()-1;
        if(str.length()<=1)
        {
            return true;
        }
        if (str.charAt(0) != str.charAt(lastPos))
        {
            return false;
        }
        String newStr=str.substring(1,lastPos);
        return isPalindrome(newStr);

    }
}

/*
ANOTHER LOGIC

import java.util.Scanner;

class Challenge2_7_17_69
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string to be checked: ");
        String str = input.next();

        System.out.print(str + " is " + (isPalindrome(str, 0, str.length() - 1) ? "Palindrome" : "NOT Palindrome"));
    }

    public static boolean isPalindrome(String str, int start, int end)
    {
        if (start >= end)
        {
            return true;
        }

        if (str.charAt(start) != str.charAt(end))
        {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }
}
*/