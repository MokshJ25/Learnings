package in.MyPackage2_810NestedAndInnerClass;

public class Car2_810_1
{
    private int numberOfDoors;
    public void repair()
    {
        Tyre t=new Tyre();
    }
    public static class Tyre
    {
        private double width;
        private double pressure;
        private String material;

        public void inFlate()
        {
            numberOfDoors = 4;/*we cannot access this property as this is not static. if we declare out this inner
                               class as non static, then we can access this non-static property of outer class. */
        }
    }
}
