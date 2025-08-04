package in.MyPackage2_8Tester;

import in.MyPackage2_85GetterSetter.Car2_85_1;

public class GetterTest2_85_2
{
    public static void main(String[] args)
    {
        Car2_85_1 car = new Car2_85_1("Red","Maruti", 2, 60000,"22/06/24");
        System.out.printf("%s %s",car.getColor(), car.getModel());
    }
}
