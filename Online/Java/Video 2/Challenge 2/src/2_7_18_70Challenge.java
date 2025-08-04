//WAP  to use toString to print student details:

class Student
{
    String name;
    int age;

    public Student(String name, int age)
    {
        this.name=name;
        this.age=age;
    }

    public String toString()
    {
        return "Student {" + "Name: " + name + "/" + "Age: " + age + "}";
    }

    public static void main(String[] args)
    {
        Student abc =new Student("Moksh", 21);
        System.out.print(abc);
    }
}
