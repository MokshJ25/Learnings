class Driver1
{
    public static void main(String[] args)
    {
        //DECLARING OBJECT:
        Car1 myCar; // "muCar" is a reference of "Car" class
        myCar=new Car1(); // "Car" class is created in 2_62_1
        /*-> here, "myCar" is not holding the valuse of the object, it is holding the address of the object.
          -> here "Car()" is Constructor
          -> new" java ka keyword hai jo class ko instantiate karne me use hota hai. yani class ki actial copy
             (object) banae ke lie "new" use hota hai*/

        /*  yaha hamare pass "Car" naam ki class already bani hui thi, jiska hamne yaha ek "myCar" naam ka
            variable(reference) declare kar dia.
            generally "int a;" me ham ek variable declare karte hai jo integer type ka hai. par "Car myCar"
            me hamne ek variable(reference) declare kiya hai jo "Car" class ka hai. or ye variable ek reference
            (address) store karta hai. fir hamne next line me "myCar=new Car()" likha jiska "new Car()" btata
            hai ki hamne ek new object banaya hai "Car" class ka or "myCar=new Car()" btata hai ki hamne ye
            object "myCar" me jo reference aaya tha waha store karwaya hai(obviously) */

        //USING OBJECT:
        myCar.drive();
        myCar.addFuel(6);
        myCar.drive();
        myCar.drive();
        myCar.drive();
        myCar.addFuel(3);
        System.out.println(myCar.getCurrentFuelLevel()+" lt");
    }
}
