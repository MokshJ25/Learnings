import java.util.Scanner;
class WhileLoop1_52_1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);


        System.out.println("Printing numbers till 10:");
        int a=1;
        while(a<=10)
        {
            System.out.println(a);
            a+=1;
        }

        System.out.println("Printing reverse numbers from 10: ");
        int b=10;
        while(b>0)
        {
            System.out.println(b);
            b-=1;
        }

        System.out.println("Taking 3 input from users: ");
        int c=1;
        while(c<=3)
        {
            System.out.println("Enter the number at " +c+ " position: ");
            int d=input.nextInt();
            System.out.println("You just entered: "+d);
            c+=1;
        }

    }
}
