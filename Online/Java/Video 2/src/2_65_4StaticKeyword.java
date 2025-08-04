class Driver3
{
    static int minAge=18; // ye "static variable" hai yani ye static method se access ho sakta hai
    int age;
    String name;
    String dateOfLicense;

    public static void main(String[] args) /* yaha "static" laha hai matlab ye method bina object banae bhi
                                              access ki ja sakti hai*/
    {
        Car3 swift= new Car3();
        swift.addFuel(6);
        swift.start().drive();
/*
        name=ABC;                // Yaha hame "name", "dateOfLicense" variable use nahi kar paa rahe hai
        dateOfLicense="01/01/98" // kyuki ham "static" method ke andar hai or yaha ham non-static chize access
                                    nahi kar paenge bina oblect bnae.
*/
        Driver3 myDriver=new Driver3();
        myDriver.dateOfLicense="01.01/98"; /* here, we can use instance variable(dateOfLicense) because we have
                                              made the object of this class, so since we have defined the
                                              object ki mujhe kis object ka non-static data access karna hai
                                              to we get able to access the non-static data inside a static
                                              method.*/
        System.out.println(minAge); /* yaha "minAge" jo ek "static variable" hai use access kar pae kyuki we
                                       can access "static variables" from a "static" method*/
/*      System.out.println(myDriver.minAge); // static items ko ham class_name.static_item_name laga kar
                                                access karte hai pas ham object_name.item_name laga kar
                                                bhi access kar sakte hai. par the object_name must be of
                                                thet class only(obviously) (allowed but not recommended)*/
/*      System.out.println(Driver.minAge); // static items ko ham class_name.static_item_name laga kar
                                              access karte hai(recommended)

    }

    public boolean isAllowedToDrive() //this is a non-static method
    {
        return this.age>=minAge; /* since this is a non-static method to yaha instance variables jo
                                    non-static or static hai unko bhi access kar paa rahe hai.  */

    }
}
