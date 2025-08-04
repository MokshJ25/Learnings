import java.util.Scanner;
class Paremeter1_55_1
{
    public static void main(String[] args)
    {
        int a = sum(1,2);
        System.out.println("Sum is: "+a);
//  or  System.out.println(sum(1,2));
        System.out.println("Sum is:  "+sum(10,2));
        System.out.println("Sum is:  "+sum(15,27));
        System.out.println("Sum is:  "+sum(-17,21));

    }


    public static int sum(int first, int second)
    {
        System.out.println("First number received: "+first);
        System.out.println("Second number received: "+second);
        int add=first+second;
        return add; //we can remove the above assignment and can write this line as "return first+second;"
    }
}
