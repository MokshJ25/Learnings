
class Car1
{
    int noOfWheels;  //Instance Variables or Instance Properties
    String colour; //Instance Variables or Instance Properties
    float maxSpeed; //Instance Variables or Instance Properties
    float currentFuelInLiters; //Instance Variables or Instance Properties
    int noOfSeats; //Instance Variables or Instance Properties

    public void drive()// These are the Instance methods or Instance functions
    {
        if(currentFuelInLiters==0)
        {
            System.out.println("Car is out of Fuel, please refuel");
        }
        else if(currentFuelInLiters<=5)
        {
            System.out.println("Car is in reserved mode, please refuel");
            currentFuelInLiters--; //yah bta raha hai ki jab bhi car chale, 1lt fuel minus kardo
        }
        else
        {
            System.out.println("Car is driving");
            currentFuelInLiters--; //yah bta raha hai ki jab bhi car chale, 1lt fuel minus kardo
        }
    }
    public void addFuel(float fuel)// These are the Instance methods or Instance functions
    {
        currentFuelInLiters+=fuel;
        System.out.println("Current fuel level is: "+currentFuelInLiters+" lt");
    }
    public float getCurrentFuelLevel()// These are the Instance methods or Instance functions
    {
        return currentFuelInLiters;
    }

    public static void main(String[] args)
    {

    }
}
