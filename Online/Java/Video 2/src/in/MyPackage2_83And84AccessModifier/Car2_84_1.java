package in.MyPackage2_83And84AccessModifier;

public class Car2_84_1
{
    public String color;
    public String model;
    private double fuelLevel;
    private long cost;
    String dateOfPurchase;

    public Car2_84_1()//have to make constructors public so that we can use it where ever we want to create objects
    {

    }
    public Car2_84_1(String color, String model, double fuelLevel, long cost)//""""""""""""""""""
    {
        this.color = color;
        this.model = model;
        this.fuelLevel = fuelLevel;
        this.cost = cost;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Car2_84_1{");
        sb.append("color='").append(color).append('\'').append(", model='").append(model).append('\'');
        sb.append(", fuelLevel=").append(fuelLevel).append(", cost=").append(cost).append('}').append("\n");
        return sb.toString();
    }
}
