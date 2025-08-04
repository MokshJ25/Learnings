class Driver5
{
    public static void main(String[] args)
    {
    /* -> yaha jab tak ham "Car5()" me brackets ke andar parameter ki actual value pass nahi
          karenge, hamara object nahi ban sakta, i.e., we can enforce ki yadi ye object banana
          hai to ye value to deni hi padegi, isko bola jata hao CONTRACT.
       -> in "Car5" class, hamne "Car5()" constructor ko parameterized banaya tha, jime hamne
          parameter me color pass karwaya tha, to ab ja yaha hamne object bnaya yani constructor
          call kia to yaha hame us parameter ki actual value dene padi, jo yaha hamne "Red" rakhi  */
        Car5 swift= new Car5("Red"); //here "Car5()" is a Parameterized constructor
        System.out.println(swift.color);

        /* ab yaha 2_66_3 me hamne 2 constructors pass karwae hai, ek parameterized hai jisme
           hamne "color" parameter dia hua hai or dusre me hamne koi parameter nahi dia hai.
           ab yadi yaha hamko aisa object banana hai jisme ham car ka color default rake to ham
           bina parameter wala constructor call kar sakte hai kyuki hamne waha us unparameterized
           construct me andar default color de rakha hai.
           in simple words ab hamare paas do constructs available hai from 2_66_3 ek jisme hame
           parameter dena padega or ek jisme nahi dena padega, ab we can use both as per our need.*/
        Car5 thar=new Car5(); //here "Car5" is un-parameterized constructor to yaha hame
        System.out.println(thar.color);
    }
}
