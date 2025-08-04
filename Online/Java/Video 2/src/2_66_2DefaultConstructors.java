class Driver4
{
    public static void main(String[] args)
    {
        Car4 swift= new Car4(); //here "Car4()" is a Default constructor
        swift.start().drive();
        System.out.println(swift.noOFSeats);
        System.out.println(swift.maxSpeed);
        /* since hamne "swift" naam ka object bnaya hai "Car4" class ka, jisme "Car4" naam ka constructor
           bhi hamne define kia hai kisme "color", "noOfSeats", "maxSpeed" wagerah define karke rakhe hai
           constructor ke andar, to jab hamne in teeno ki values print karwai to wo print ho gai kyuki
           wo hamne by default set karwai thi constructor(Car4) ke andar. */
    }
}
