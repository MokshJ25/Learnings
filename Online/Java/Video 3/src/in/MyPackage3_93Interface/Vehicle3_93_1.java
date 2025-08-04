package in.MyPackage3_93Interface;

public abstract class Vehicle3_93_1 implements Transport3_93_3//to inherit interface, use "implements" not "extends"

/*since we have implemented "Transport3_93_3" interface here to we have to give defination of the public abstract
  (by default) methods given in that interface, because that interface is parent of this class, but if we wish, we
  can give defination of that methon in child of this class also. means we have choice, we have to deine that methode
  here, but if we want, we can define in subclass of this class also.*/
{
    private int noOfTyres;

    public Vehicle3_93_1(int noOfTyres)
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


    public abstract void makeStartSound();

    void commute()
    {
        System.out.println("Travelling");
    }
}
