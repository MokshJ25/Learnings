package in.MyPackage2_89EqualsAndHashCode;

public class Tester2_89
{
    public static void main(String[] args)
    {
        Person2_89_1 person1 = new Person2_89_1("Moksh", 21,"001");
        Person2_89_1 person2 = new Person2_89_1("Moksh", 21,"001");

        if(person1.equals(person2)) /*(before creating "equals()" method in "Person2_89_1"):
                                      it will always print "Not Equal"(else part) because ye ab bhi person1 or person2
                                      ke references hi compare kar raha hai. yadi ye String wala object hota jisko
                                      ham "new" laga ke declare nahi karte hai to ye values String pool me jaati
                                      or since ye String wala object hota to ye "Equals" print karwata kyuki if
                                      wali condition true rehti tab kyuki String ne apne lie "equals()" method ko
                                      override kar rakha hai. or yadi ham "equals()" ko hamare lie override nahi karte
                                      hai to wo bhi references ko hi compare karta hai(Jaisa yaha hua).*/
        /*now, we have created "equals()" method in "Person2_89_1" class, therefore it will compare the values
          inside our this objects of this class. therefore now it will give the correct value.*/
        {
            System.out.println("Equal");
        }
        else
        {
            System.out.println("Not Equal");
        }
    }
}
