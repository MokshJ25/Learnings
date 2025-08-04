//WAP to print months of the year based on (1-12):

import java.util.Scanner;

class Challenge2_7_5_57
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num=input.nextInt();

        Challenge2_7_5_57 obj1=new Challenge2_7_5_57();
        String ans = obj1.month(num);
        System.out.println(ans);
    }

    public String month(int num)
    {
        return switch(num)
        {
            case 1->"January";
            case 2->"February";
            case 3->"March";
            case 4->"April";
            case 5->"May";
            case 6->"June";
            case 7->"July";
            case 8->"August";
            case 9->"September";
            case 10->"October";
            case 11->"November";
            case 12->"December";
            default->"invalid month";
        };
    }
}
