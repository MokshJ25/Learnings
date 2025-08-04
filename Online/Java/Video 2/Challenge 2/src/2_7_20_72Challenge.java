//WAP to calculate area and circumference of a circle using Math.PI:

import java.util.Scanner;

class Challenge2_7_20_72
{
    double radius;

    public Challenge2_7_20_72(double radius)
    {
        this.radius=radius;
    }

    public String toString()
    {
        return "Radius of the circle is: "+radius+"\nCircumference: "+getCircumference()+"\nArea: "+getArea();
    }

    double getCircumference()
    {
        return 2 * Math.PI * radius;
    }
    double getArea()
    {
        return Math.PI * Math.pow(radius,2);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        float radius=input.nextFloat();

        Challenge2_7_20_72 circle=new Challenge2_7_20_72(radius);
        System.out.print(circle);
    }
}
