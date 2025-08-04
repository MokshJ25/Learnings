package in2_8.Challenge2_8_5_81;

import java.util.Objects;

public class Person
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name=name;
        this.age=age;
    }

    @Override
    public boolean equals(Object obj)
    {
        if ((obj == null) || (obj.getClass() != this.getClass()))
        {
            return false;
        }
        Person person = (Person) obj;
        return person.name.equals(name) && person.age==age;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, age);
    }
}
