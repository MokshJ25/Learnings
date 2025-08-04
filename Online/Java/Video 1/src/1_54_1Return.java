import java.util.Scanner;
class Return1_54_1
{
    public static void main(String[] args)
    {
        greeting();
        int first = readNumber();
        int second = readNumber();

        int sum=first+second;
        System.out.println("Sum of the numbers is: "+sum);
    }


    public static void greeting()
    {
        System.out.println("Hello! Get ready for the execution:\n");
    }

    public static int readNumber()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter the number: ");
        int a=input.nextInt();
        return a;
    }


}
