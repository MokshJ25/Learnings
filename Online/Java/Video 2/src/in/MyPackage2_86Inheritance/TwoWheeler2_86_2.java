package in.MyPackage2_86Inheritance;

public class TwoWheeler2_86_2 extends Vehicle2_86_1 //use "extends" keyword to inherit one class into other
{
    TwoWheeler2_86_2()
    {
        noOfTyres=2; /* We have not declared "noOfTyres" property anywhere in this class, but then also we are able to
                     access this property because we have defined it in "Vehicle2_86_1" class(which we have inherited)
                     in our this class */
    }

    public void balancing()
    {
        System.out.println("Your Two Wheeler is balancing");
    }
}
