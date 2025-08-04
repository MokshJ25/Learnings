package in.MyPackage2_83And84AccessModifier;

public class AccessTester2_84_3
{
    public static void main(String[] args)
    {
        Car2_84_1 car=new Car2_84_1(); /*this is default constructor,a nd here we have not passed our private
                                         properties like "cost", and "fuelLevel", therefore we will not be able to
                                         access them with this object(as it is made using default constructor)*/
        car.color="Red";
        car.model="Swift";
//      car.cost=10000;// we are not able to access "cost", because it is a private property.
//      car.fuelLevel=1.5;// we are not able to access "fuelLevel", because it is a private property.
        car.dateOfPurchase="25/06/24"; // we can access default declared property within the same package
        System.out.print(car); // it will give 0 and  0 to "cost", and "fuelLevel" property as it is not assigned

        Car2_84_1 newCar=new Car2_84_1("Black", "BMW", 1.5, 100000);
        /*this is the second constructor we have made in our Car2_84_1 class ,and here we have passed our
        private properties like "cost", and "fuelLevel", therefore we will be able to access them with this
        object(as it is made using parametered constructor)*/
        System.out.print(newCar); /*it will give 1.5 and 100000 to "cost", and "fuelLevel" as we have assigned it in
                                    this object because it is mandatory to give the values of "cost", and
                                    "fuelLevel" in creating this object as it have taken it in Car2_84_1 class, where
                                     we have defined these private properties*/
//      newCar.cost=200000; // but after those arguments, if we again want to access those private properties, we are-
//      newCar.fuelLevel=2; //-not allowed as we cannot access it out of that class if they are declared as private
        newCar.dateOfPurchase="25/06/24"; //we can access "default" properties within the package

        DefaultAccess2_84_2 vehicle=new DefaultAccess2_84_2(); /* here we are able to make object of-
                                                                  -DefaultAccess2_84_2 class because we have declare
                                                                  it default, and we can use it within the same
                                                                  package */
//      in.AadiSeMoksh2_8.DefaultAccess2_84_2; //we cant even access it in this way because this calss is declared default
    }
}
