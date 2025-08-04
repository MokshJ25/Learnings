package in.MyPackage3_92Abstraction;

public class Tester3_92
{
    public static void main(String[] args)
    {
        Car3_92_2 car = new Car3_92_2();
//      Vehicle3_92_1 veh = new Vehicle3_92_1(4);
        /* par ham nahi chahte the ki koi bhi hamari "Vehicle3_92_1" class ka object bana paae, kyuki wo class hamne
           banai hi inherit karne ke lie thi. ab to make it possible ki hamari "Vehicle3_92_1" class ka object na
           ban pae, we have to define "abstract" keyword whih that class.*/
        /* ab since we have declare our "Vehicle3_92_1" class as absatract, we starte getting error when we are
           creating object of "Vehicle3_92_1" class*/
        car.commute(); /* we can use commute() method jabki ye "Vehicle3_92_1" class me bani hui method hai, kaise?
                          wo aise ki hamne "Vehicle3_92_1" abstract class ko inherit kia tha "Car3_92_2" class me
                          and thats why we can use the properties of abstract class in child class also*/
        car.makeStartSound();/*it was the abstract method declared in "Vehicle3_92_1" class and defined in "Car3_92_2"
                               because it is the child of "Vehicle3_92_1"*/
    }
}
