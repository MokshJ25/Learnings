//WAP to read input and break when specific word is entered("exit"):


import java.util.Scanner;

class Challenge2_7_13_65
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        do
        {
            System.out.print("Enter the String: ");
            String str=input.next();
            if(str.equals("exit")) /* we use ".equals" to equate two objects(ot if either one is object), because
                                      if we will equate them directly using "==", then the address they carry wii
                                      get equated(obviously) because they are references and they hold the address
                                      of the object they contain. therefore, we use ".equals()" or
                                      "equalsIgnoreCase()"(to ignore weather the string is in upper or lowercase) */
            {
                break;
            }
        } while(true);
        System.out.print("exited Successfully!");
    }
}
