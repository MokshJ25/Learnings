// WAP using do while as a password checker

import java.util.Scanner;

class Challenge2_7_7_59
{
    public static void main(String[] args)
    {
        String pass;
        Scanner input=new Scanner(System.in);
        do
        {
            System.out.println("Enter your Password");
            pass=input.next();
        } while(!isValidPassword(pass)); /* it means yadi isValidPassword(pass) false hai(kyuki "!" laga hua hai waha)
                                          to condition true maano or loop execute karte rahi */
        System.out.println("You have entered a valid password!");
    }

    public static boolean isValidPassword(String password)
    {
    return password.length()>6; // it returns true or false on the basis of the length of password
    }
}
