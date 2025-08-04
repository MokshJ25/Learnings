class StringBuilderDemo
{
    int noOfWheels;
    int noOfDoors;
    int maxSpeed;
    String name;
    String modelNumber;
    String company;

    public StringBuilderDemo(int noOfWheels, int noOfDoors, int maxSpeed,
                        String name, String modelNumber, String company)
    {
        this.noOfWheels = noOfWheels;
        this.noOfDoors = noOfDoors;
        this.maxSpeed = maxSpeed;
        this.name = name;
        this.modelNumber = modelNumber;
        this.company = company;
    }

    //we can make "toString()" method alkso using "stringBuilder":
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("StringBuilderDemo{");
        sb.append("noOfWheels=").append(noOfWheels).append(", noOfDoors=").append(noOfDoors);
        sb.append(", maxSpeed=").append(maxSpeed).append(", name='").append(name).append('\'');
        sb.append(", modelNumber='").append(modelNumber).append('\'').append(", company='").append(company);
        sb.append('\'').append('}').append("\n");
        return sb.toString();
    }

    public static void main(String[] args)
    {
        StringBuilderDemo swift = new StringBuilderDemo(4,4,180,"Swift",
                "Mx123","Maruti");
        System.out.print(swift.toString());

        //Also we can use "StringBuilder" like:
        StringBuilder a= new StringBuilder("My name is Moksh. ");
        a.append("I am 21 years old. ");
        a.append("i am from indore. ").append("i am in learning phase. ").append("Everything will be fine.");
        // we can also use it like String_name.append().append().append().append()// ".append()" multiple times
        System.out.print(a);// we can also write it like System.out.print(a.toString()");
    }
}
