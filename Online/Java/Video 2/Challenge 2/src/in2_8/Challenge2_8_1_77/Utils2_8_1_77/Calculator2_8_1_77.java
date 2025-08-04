package in2_8.Challenge2_8_1_77.Utils2_8_1_77;

import in2_8.Challenge2_8_1_77.Geometry2_8_1_77.Circle2_8_1_77;
import in2_8.Challenge2_8_1_77.Geometry2_8_1_77.Rectangle2_8_1_77;
// instead of upper two imports we can write: "import in2_8.Challenge2_8_1_77.Geometry2_8_1_77.*";


public class Calculator2_8_1_77
{
    public static void main(String[] args)
    {
        Circle2_8_1_77 circle = new Circle2_8_1_77(5.5);
        Rectangle2_8_1_77 rectangle = new Rectangle2_8_1_77(10, 5);

        double circArea = Math.PI * Math.pow(circle.radius, 2);
        double rectArea = rectangle.length * rectangle.breadth;

        System.out.printf("Area of circle is: %f\nArea of rectangle is: %f",circArea,rectArea);
    }

}
