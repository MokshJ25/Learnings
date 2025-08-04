//WAP to create an object with the final fields and a constructor to initialize them:

/* it is mandatory to give the value of the final variables as the get declare. but if we dont want to give the
   values of final variable at the time of declaration, then we can also assign their value in the constructors,
   because when the object will get created at that time it will be mandatory to assign the values in it otherwise
   the object will not be able to be created. */

class Challenge2_7_24_76
{
    final int noOfWheels;
    final String model;
    final String engine;
    final int noOfSeats;

    public Challenge2_7_24_76(int noOfWheels, String model, String engine, int noOfSeats)
    {
        this.noOfWheels = noOfWheels;
        this.model = model;
        this.engine = engine;
        this.noOfSeats = noOfSeats;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Challenge2_7_24_76 {");
        sb.append("noOfWheels = ").append(noOfWheels).append(", model = '").append(model).append('\'');
        sb.append(", engine = '").append(engine).append('\'').append(", noOfSeats = ").append(noOfSeats).append('}');
        return sb.toString();
    }

    public static void main(String[] args)
    {
        Challenge2_7_24_76 swift = new Challenge2_7_24_76(4,"swift","v2",5);
        System.out.print(swift);
    }
}


