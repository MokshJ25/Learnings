class Car6
{
    static int noOfCarsSold;
    float currentFuelInLiters;
    String color;
    int noOFWheels;
    float maxSpeed;
    int noOFSeats;

    /* -> isme ham static variable call,set,modify kar sakte hai.
       ->yah programm jab run hota hai to us lifetime me sirf ek baar hi call hota hai.
         yah tab hi call hota hai jab class pehli baar load hoti hai execution me */
    static
    {    // it is STATIC code block
        noOfCarsSold = 0;
        System.out.println("i am in Static Block");
    }

    /* -> saare constructors se pehle ye wala code block call hota hai. jab object banta hai tab
          constructors ke bhi pehle yah call hota hai.
       -> yah har object ke create hone par call hota hai, kyuki jab bhi object banta hai to
          constructors call hote hai, or ye to constructor ke call hone ke pehle call hota hai,
          to har object creation ke sath ye to call hoga hi.*/
    {     // it is Initialization code block
        noOfCarsSold++;
        System.out.println("i am in Initialization Block");
    }

    Car6(String color)
    {
        this.color = color;
        noOFWheels = 4;
        maxSpeed = 150;
        currentFuelInLiters = 2;
        noOFSeats = 5;
    }

    Car6()
    {
        this("Black");
    }

    public Car6 start()
    {
        if (currentFuelInLiters == 0)
        {
            System.out.println("Car is out of Fuel, Car will not start");
        } else if (currentFuelInLiters <= 5)
        {
            System.out.println("Car is in reserved mode, please refuel");
        } else
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
}
