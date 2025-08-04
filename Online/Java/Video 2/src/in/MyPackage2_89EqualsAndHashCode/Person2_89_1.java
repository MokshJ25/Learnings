package in.MyPackage2_89EqualsAndHashCode;

import java.util.Objects;

public class Person2_89_1
{
    private String name;
    private int age;
    private String id;

    public Person2_89_1(String name, int age, String id)
    {
        this.name = name;
        this.age = age;
        this.id = id;
    }


    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }


    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Person2_89_1{").append("name='").append(name).append('\'');
        sb.append(", age=").append(age).append(", id='").append(id).append('\'').append('}');
        return sb.toString();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, age, id);
    }

    /*if we want ki jab ham objects par bhi "equals()" call kare to hamara result bhi String ke "equals()" ke jasie
          act kare, i.e. values compare kare naa ki references, to hame hamara "equals()" define karna padega kyuki
          "equals()" by default reference hi compare karta hai rather than the value. String ne bhi "equals()" khud ke
          lie define karke rakha hai, therefore ab ham hamare lie "equals()" define karenge taaki wo hamare objects ke
          andar ki values compare kare na ki references.*/
    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Person2_89_1)) //here "instanceof" is a keyword which tells ki left side wala right side-
        {                                  //-ka object hai ki nahi.
            return false;
        }
        Person2_89_1 per = (Person2_89_1) obj;/*ab if "if" condition is false,to hame pata chal gaya hai ki hamara
                                                "obj" "Person2_89_1" class ka hi instance hai to hamne us "obj" ko
                                                "Person2_89_1" type me hi cast kardo. for this, we can do:
                                                "Person2_89_1" class type ka ek variable banao (here "per"), usme
                                                "obj" daal do usko "Person2_89_1" type me cast karke*/
        return per.name.equals(name)&&per.age==age&&per.id.equals(id);
        /*in the above line we have used "equals()" ye "equals()" wo wala equals nahi hai jisko ham yaha define kar
          rahe hai. ye wala "equals()" we String comparision wala "equals()" hai jo string equal hai ya nahi wo
          compare karta hai.*/

    /*
    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Person2_89_1))
        {
            return false;
        }
        Person2_89_1 per = (Person2_89_1) obj;
        return per.name.equals(name)&&per.age==age&&per.id.equals(id);
    }
    */
    }
}
