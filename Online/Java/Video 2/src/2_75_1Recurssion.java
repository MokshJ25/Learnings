import java.util.Scanner;

class Recurssion
{
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the number to find factorial: ");
        int num=input.nextInt();

        System.out.println("Factorial using iteration method is being executed");
        long fact1= factorialUsingIterative(num);
        System.out.println("Factorial of your number is: "+fact1);
        System.out.println("Factorial using recursion method is being executed");
        long fact2= factorialUsingRecursion(num);
        System.out.println("Factorial of your number is: "+fact2);
    }

    public static long factorialUsingIterative(int num)
    {
        long result = 1;
        for(int i=1; i<=num ; i++)
        {
            result*=i;
        }
        return result;
    }
    public static long factorialUsingRecursion(int num)
    {
        //System.out.println("Recursion Function call for: "+num);
        if(num==1)
        {
            return 1;
        }
        return num * factorialUsingRecursion(num-1); //here,  we have used recursion.
        /* ex.: lets take number 5:
           return 5*factorialUsingRecursion(4);//here the function will call itself for num-1
           then, return 5*4*factorialUsingRecursion(3); // here also
           again, return 5*4*3*factorialUsingRecursion(2); //here also
           again, return 5*4*3*2*factorialUsingRecursion(1); //here also
           and here, we get num==1, our if condition will get true and it will be conducted and will get finally 1
           at the place of factorialUsingRecursion(1), which our "5*4*3*2*factorialUsingRecursion(1)" statement
           will return, so finally we will get "return 5*4*3*2*1" and this will be finally returned.*/
    }
}
