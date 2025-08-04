class Car4
{
    float currentFuelInLiters;
    String color;
    int noOFWheels;
    float maxSpeed;
    int noOFSeats;

    Car4() // yha hamne ek constructor explicitly define kiya hai //Default Constructor
    {
        /* yaha ham hamare constructor me kuch ideal vaues daal rahe hai ji hamare har object me
           by default jaegi yani by default hamne hamare constructor me variables(properties) ki
           value set kar di hai par baad me jab object tab wo values baad me modify kar sakte hai.
           yani yadi ham chahte hai ki hamare object bane of usme kuch values already defined ho,
           to wo ham constructor me define kar sakte hai.1*/
        noOFWheels=4;
        maxSpeed=150;
        currentFuelInLiters=2;
        noOFSeats=5;
    }

    public Car4 start()
    {
        if(currentFuelInLiters==0)
        {
            System.out.println("Car is out of Fuel, Car will not start");
        }
        else if(currentFuelInLiters<=5)
        {
            System.out.println("Car is in reserved mode, please refuel");
        }
        else
        {
            System.out.println("Car is Started");
            currentFuelInLiters--;
        }
        return this;
    }
    public void drive()
    {
        currentFuelInLiters--;
        System.out.println("Car is driving");
    }
    public void addFuel(float currentFuelInLiters)
    {
        this.currentFuelInLiters+=currentFuelInLiters;
        System.out.println(+currentFuelInLiters+"lt Fuel is Added, Current fuel " +
                "level is: "+this.currentFuelInLiters+" lt");
    }
    public float getCurrentFuelLevel()
    {
        return currentFuelInLiters;
    }
}
