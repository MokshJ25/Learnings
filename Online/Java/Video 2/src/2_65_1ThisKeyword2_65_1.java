
class Car2
{
    float currentFuelInLiters;

    public Car2 start() /* Yaha ye method Car2(class) type ki chiz(instance method, instance variable)
                           ko hi return karegi */
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
        return this;  //Yaha ye "this" keyword khud ko hi (is method ko hi) return karwa raha hai
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
        /*
        yaha hamne "addFuel" method ke parameter me "currentFuelInLiters" naam ka variable pass karwa dia
        par is naam ka instance variable hamare paas already tha, par parameter me same naam ka variable paas
        karne se confusuin create ho gaya, so to distinct the instance variable with the local variables,
        we put "this." in from of instance variables(where needed) taaki compiler ko bhi clear ho ki yaha local
        variable kon sa hai or instance variable kon sa hai.
        like here we have passes "currentFuelInLiters" in parameters to method to usko hi priority degi or jaha
        bhi "currentFuelInLiters" use hoga us method me waha wo usko parameter wala local variable hi samjeegi,
        so to make out compiler understand ki kon instance variable hai, kon local variable hai, konse variable
        me usko real me store karna hai, wo ye "this."(tells about instance variable) bataega. yadi ye use nahi
        karte to method local variable jaisa hi treat karta.
        in simple words mujhe yadi kahi bhi apni class ka koi bhi property(instance variable) use karna hai,
        instance method use karna hai, to uske lie, "this." laga sakte hai jisse koi bhi confussion naa rahe.
        jab bhi hame kahi dikhega "this.", ye proof dega ki ham apni instance variable ya instance method ko
        use kar rahe hai. {"this."=> current obj
        ect/meri class ka variable}
         */
    }
    public float getCurrentFuelLevel()
    {
        return currentFuelInLiters;
    }

    public static void main(String[] args)
    {

    }
}
