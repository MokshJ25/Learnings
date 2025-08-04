package in.MyPackage2_86Inheritance;

public class Tester2_86
{
    public static void main(String[] args)
    {
        Vehicle2_86_1 vehicle = new Vehicle2_86_1();
        vehicle.travel(); /*we have defined "travel()" method in "Vehicle2_86_1" class thats why we are able to use it-
                          -in its object "vehicle" */

        TwoWheeler2_86_2 two = new TwoWheeler2_86_2();
        two.travel(); /*we have inherited "Vehicle2_86_1" in "TwoWheeler2_86_2" class, thats why we are able to access-
                      -"travel()" method of "Vehicle2_86_1" class in object of our "TwoWheeler2_86_2" class */
        two.balancing(); // "balancing()" is defined in the class only jiska "two" object hai

        Motorcycle2_86_3 bike=new Motorcycle2_86_3();
        bike.travel();/* we can inherit "travel()" method in object of "Motorcycle2_86_3" class also because we have
                         inherited "TwoWheeler2_86_2" class in our "Motorcycle2_86_3" class and "TwoWheeler2_86_2"
                         has inherited "Vehicle2_86_1" class, where "travel()" method is declared. also, we will also
                         inherit the value of "noOfTyres" property here because we have given its value in
                         "TwoWheeler2_86_2" class (which we have inherited in "Motorcycle2_86_3") */
        bike.balancing(); /* we can access "balancing()" in this also because we have inherited "TwoWheeler2_86_2"
                             class in class of this object.*/
        bike.start();// "start()" is defined in the class only jiska "bike" object hai
    }
}
