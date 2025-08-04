package in2_8.Challenge2_8_5_81;

public class Tester2_8_5_81
{
    public static void main(String[] args)
    {
        Person per1 = new Person("Moksh",21);
        Person per2 = new Person("Moksh",21);

        if(per1.equals(per2))
        {
            System.out.println("Both objects are equal");
        }
        else
        {
            System.out.println("No, they are not equal-");
        }
    }
}
