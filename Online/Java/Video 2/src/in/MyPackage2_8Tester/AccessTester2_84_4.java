package in.MyPackage2_8Tester;

import in.MyPackage2_83And84AccessModifier.Car2_84_1; /* we have to import this if we want to make the object of class from another
                                       package, same as we import java.util.Scanner to make object of Scanner class */

public class AccessTester2_84_4
{
    public static void main(String[] args)
    {
        Car2_84_1 car = new Car2_84_1("Yellow","Dezire",2,40000);
//      car.cost= ;//cant use private prop. out of the class in which it has declared. ye to fir bhi dusra package hai
//      car.dateOfPurchase =" "// " " default " " " " package " " " " ". ye dusra package hai
        car.color="White"; // we can access "color", and "model" here also (out of the package) because they are-
        car.model="Baleno"; //-public properties.

/*      DefaultAccess2_84_2 vehicle=new DefaultAccess2_84_2();// here we are unable to make object of-
      -DefaultAccess2_84_2 class because we have declare it default, and we cant use it outside that package */
    }
}
