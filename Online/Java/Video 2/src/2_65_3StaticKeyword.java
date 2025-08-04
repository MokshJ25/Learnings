class Car3
{
    float currentFuelInLiters;

    public Car3 start()
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

    public static void main(String[] args)
    {

    }
}
