package in2_8.Challenge2_8_3_79;

public class Employee2_8_3_79
{
    private String name;
    private int age;
    private double salary;

    Employee2_8_3_79(String name, int age, double salary)
    //we have made this method as default because we want ki isko package ke bahar koi access na kar pae
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }

    public double getSalary()
    {
        return salary;
    }
    public void setSalary(double salary)
    {
        this.salary=salary;
    }


    String displayEmployeeDetails()
    {
        return "\nEmployee Name: "+name+", Employee Age: "+age+", Employee Salary: "+salary;
    }
}
