package in.MyPackage2_85GetterSetter;

/*Encapsulation kehta hai, jo chiz chupani hai wo puri tarah chupao or setter usme add karte hue kehta hai ki jo
  dikhani bhi hai uska direct access mat karne do. uska method bana do jisse user us property ko access kar pae. */

public class Car2_85_1
{
    private String color; // make it public
    private String model; // make it public
    private double fuelLevel;
    private long cost;
    private String dateOfPurchase; // make it default

    public Car2_85_1(String color, String model, double fuelLevel, long cost, String dateOfPurchase)
    {
        this.color = color;
        this.model = model;
        this.fuelLevel = fuelLevel;
        this.cost = cost;
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getColor()//since it is public, we can access it anywhere we want to and also in any package
    {
        return color;
    }
    void setColor(String color)// since this setter method is default, we can access it in this package only
    {
        this.color = color;
    }
    public String getModel()
    {
        return model;
    }

}
