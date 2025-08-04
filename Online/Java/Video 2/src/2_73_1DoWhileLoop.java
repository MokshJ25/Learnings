// user ki age lo, yadi gae 0 se kam ya 100 se zyada hai to baar baar age maango jab tak sahi age nahi de deta

import java.util.Scanner;

class DoWhileLoop
{
    public static void main(String[] args)
    {
        whileLoop();
        doWhileLoop();
    }

    public static void whileLoop()
    {
        System.out.println("While loop in execution");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        while(age<0||age>100)
        {
            System.out.print("Enter your age: ");
            age = input.nextInt();
        }
        System.out.println("Your age is: "+age);
    }
    public static void doWhileLoop()
    {
        System.out.println("Do while loop in execution");
        Scanner input = new Scanner(System.in);
        int age;
        do
        {
        System.out.print("Enter your age: "); //do while me hame ye or neeche wali line 2 baar nahi likhni padi0
        age = input.nextInt();
        } while(age<0||age>100);
        System.out.println("Your age is: "+age);
    }
}
