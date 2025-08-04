package in2_8.Challenge2_8_3_79;

public class Tester2_8_3_79
{
    public static void main(String[] args)
    {
        Employee2_8_3_79 emp = new Employee2_8_3_79("Moksh",21,1234567);
        System.out.print(emp.displayEmployeeDetails());
        emp.setName("Gungun");
        System.out.print(emp.displayEmployeeDetails());

    }
}
