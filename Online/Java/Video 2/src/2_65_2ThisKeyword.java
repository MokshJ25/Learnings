class Drive2
{
    public static void main(String[] args)
    {
        Car2 swift= new Car2();
        swift.addFuel(6);
/*      swift.start();     yaha "swift.start" "Car2" ka ek reference return kar raha hai jo hamne 2_65_1 me
                           banaya hai. yaha "swift" hamne Car2 ka object banaya hai to yaha jo hamne ".start"
                           method call ki hai wo bhi Car2 class ki bhi hogi  (obviously) { clear
                           karna zauri tha kyuki "Car" class me bhi ek "start" method hai}.
                           Ab kyuki hamne "Car2" me start method me "this" use karke puri ki puri method
                           hi return karwa di hai to yaha "swift.start()" "Car2" ki "start()" method ki
                           hi returned value contain kar rahe hai isilie ham ye "swift.start()" ko ek
                           variable me bhi store karwa sakte hai, jaise "Car carStarted = swift.start();"  */
//      Car2 carStarted = swift.start();
//      carStarted.drive();//=> swift.Start().drive()
        swift.start().drive(); /*=> using "this" keyword, we can return the whole method internally and can
                                    do Chaining*/

    }
}
