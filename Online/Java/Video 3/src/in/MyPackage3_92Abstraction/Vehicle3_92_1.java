package in.MyPackage3_92Abstraction;

public abstract class Vehicle3_92_1 /* "abstract" keyword makes our class abstract, i.e., isko sirf inherit kia ja
                                      sakega, iske object nahi bana paega koi */
{
    private int noOfTyres;

    public Vehicle3_92_1(int noOfTyres)
    {
        this.noOfTyres = noOfTyres;
    }

    public int getNoOfTyres()
    {
        return noOfTyres;
    }

    public void setNoOfTyres(int noOfTyres)
    {
        this.noOfTyres = noOfTyres;
    }


    public abstract void makeStartSound(); /* this is an abstract method, jo sirf declare hoti hai, iski defination
                                             dena wo child ki compulsory zimmedari hoti hai jo ise inherit karte hai*/

    void commute()
    {
        System.out.println("Travelling");
    }
}
