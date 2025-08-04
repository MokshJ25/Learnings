package in.MyPackage3_92Abstraction;

public class Car3_92_2 extends Vehicle3_92_1
{
    private int noOfDoors;

    public Car3_92_2() /*har constructor ko apne parent ka constructor call karna padta hai yadi hamne parent me bhi
                         constructor define kia hai to.*/
    {
        super(4);
    }

    @Override
    public void makeStartSound() /*it is compulsory to define this method here, as it is the abstract method of its
                                   parent class, and we have to define it, otherwise we will not be able to proceed*/
    {
        System.out.println("Broommmmm!!!");
    }
}
