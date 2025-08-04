/*WAP to distribute the discount. if age is<5 then 75%, if female than 50% and if senior citizen,
  then 25% off.*/
import java.util.Scanner;
class Logical1_48_1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age=input.nextInt();
        System.out.print("Are you female? (true/false)");
        boolean isFemale=input.nextBoolean();

        if(age<5)
        {
            System.out.println("You got 75% Discount");
        }
        else if(isFemale)
        {
            System.out.println("You got 50% Discount");
        }
        else if(age>60 && !isFemale)
        {
            System.out.println("You got 25% Discount");
        }
        else
        {
            System.out.println("No Discount");
        }
    }
}
