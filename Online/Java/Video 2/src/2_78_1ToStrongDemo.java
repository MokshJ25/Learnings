/*
class ToStringDemo
{
    int noOfWheels;
    int noOfDoors;
    int maxSpeed;
    String name;
    String modelNumber;
    String company;

    public ToStringDemo(int noOfWheels, int noOfDoors, int maxSpeed,
                        String name, String modelNumber, String company)
    {
        this.noOfWheels = noOfWheels;
        this.noOfDoors = noOfDoors;
        this.maxSpeed = maxSpeed;
        this.name = name;
        this.modelNumber = modelNumber;
        this.company = company;
    }

    public static void main(String[] args)
    {
        ToStringDemo swift = new ToStringDemo(4,4,180,"Swift",
                                              "Mx123","Maruti");
        System.out.print(swift);//this will give "classname"+"@"+"hashcode" because we have not defined toString
                                //method here thats why it is giving its default value here
    }
}
*/

class ToStringDemo
{
    int noOfWheels;
    int noOfDoors;
    int maxSpeed;
    String name;
    String modelNumber;
    String company;

    public ToStringDemo(int noOfWheels, int noOfDoors, int maxSpeed,
                        String name, String modelNumber, String company)
    {
        this.noOfWheels = noOfWheels;
        this.noOfDoors = noOfDoors;
        this.maxSpeed = maxSpeed;
        this.name = name;
        this.modelNumber = modelNumber;
        this.company = company;
    }

    @Override
    public String toString()
    {
        return "This is my Car"+name; // we have defined "name" already and have initialized it in our object
    }

/* we can also mane "toString()" method like this. providing selected details about the object
    @Override
    public String toString()
    {
        return "ToStringDemo{" + "noOfWheels=" + noOfWheels + ", noOfDoors=" + noOfDoors + ", maxSpeed=" + maxSpeed +
                ", name='" + name + '\'' + ", modelNumber='" + modelNumber + '\'' + ", company='" + company + '\'' +
                '}';
                // we can select whatever properties we want to shoe. if something is confidential, then we must not
                //keep it in "toString()" so when someone prints the object so the confidential thing doesnt appear
    }
*/
    public static void main(String[] args)
    {
        ToStringDemo swift = new ToStringDemo(4,4,180,"Swift",
                "Mx123","Maruti");
        System.out.print(swift.toString());// provide all the information we have provided in "toString" method
        //System.out.print(swift); // we can also ignore ".toString" because it will be called by default (implicitly)
    }
}
