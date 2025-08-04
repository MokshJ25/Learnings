class Car5
{
    float currentFuelInLiters;
    String color;
    int noOFWheels;
    float maxSpeed;
    int noOFSeats;

    /* yaha hamne hamare constructor ke andar parameters pass karwa dia hai "color" naam ko,
       jo "color" ki value lega jab constructor call hoga or yaha par "color" ki jagah daalega.

       constructor caqlling ke time jab tak ham "Car5()" me brackets ke andar parameter ki actual
       value pass nahi karenge, hamara object nahi ban sakta, i.e., we can enforce ki yadi ye object banana
       hai to ye value to deni hi padegi, isko bola jata hao CONTRACT.aise kitne bhi parameters
       ham daal sakte hai, lekin sabki value fir hame constructor calling(object banana) ke waqt
       daalna padegi*/
    Car5(String color) //Parameterized Constructor
    {
        this.color=color; /* here we have used "this.color" ye btane ke lie ki "this" ke sath jo
                             "color" use hua hai wo parameter wala "color" nahi hai, wo yahi class
                             wala instance variable wala "color" hai */
        noOFWheels=4;
        maxSpeed=150;
        currentFuelInLiters=2;
        noOFSeats=5;
    }
    /* yaha ham ek or constructor define kar sakte hai same hi class me jo unparameterized hoga yani
       jab is wale constructor ko call karke ham object banaenge to usme hame zarurat nahi hogi parameter
       pass karwane ki. to yadi hame ek parameter pass karwana hai hamare object me to upar wala
       constructor call karke object bana lo or yadi nahi pass karwana hai to neeche wala call karke
       pass karwa lo. it is like the concept of polymorphism*/
    Car5() //no-Parameter Constructor
    {
        color="Black";
        noOFWheels=4;
        maxSpeed=150;
        currentFuelInLiters=2;
        noOFSeats=5;
    }
    /* ya ham ye upar wale constructor ko aise bhi bana sakte hai:
        Car5()
        {
            this("Black"); // "this" statement must be the first statement
            currentFuelInLiters=5;
        }
        -> yaha hamne upar wale constructor(jisme 1 parameter set hai) uske parameeters satisfy kiye
           hai to wo call hoga or uske andar ki sare chise bhi chalegi isme, fir next line me hamne
           "currentFuelInLiters" ko update karke 5 pe set kar dia. {ye btate hue ki jo upar wala
           (1 parameter) wala call karega object banaega usko 2lt fuel milega or ye wala jo call
           karke object banaega usko 5lt fuel milega}
        -> kyuki hamne upar parameterized constructor bana lia hai, jisme sirf color ka antar hai, to
           ye dusra constructor bana do jisme zero parameters hai, wo khud ko "this" se call kar lega
           or usme "black" ya or koisa bhi color pass karwa dega wo wo default banana chahega
           This is called CONSTRUCTOR CHAINING jaha ek constructor dusre ko call karta hai khud me hi
           .or dusre wale ke parameters ko khud hi fulfill karta hai*/

    public Car5 start()
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
