//WAP to take array of words and concatenate them using StringBuilder:

import java.util.Scanner;

class Challenge2_7_23_75
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] arr=new String[]{"Everything", "will", "be", "Great"};
        StringBuilder sb=new StringBuilder();

        for (String str : arr)
        {
            sb.append(str).append(" ");
        }
        System.out.print(sb);
    }
}
