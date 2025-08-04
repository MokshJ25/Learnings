import java.util.Scanner;

class UserInput1_37_1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); //here "input" has become an object and RHS shows creation of new object of "Scanner" class
        System.out.print("Please Enter your Name: ");
        String name = input.nextLine(); //here "name" is the variable of the "input" object
        System.out.println("Good morning " + name);
        System.out.print(name + " What is your age? ");
        int age = input.nextInt();
        System.out.println(name + " Your age is : " + age);
    }
}

