package in.MyPackage3_93Interface;

import in.MyPackage3_93Interface.Vehicle3_93_1;

public class Car3_93_2 extends Vehicle3_93_1
{
    private int noOfDoors;

    public Car3_93_2()
    {
        super(4);
    }

    @Override
    public void makeStartSound()
    {
        System.out.println("Broommmmm!!!");
    }

    @Override
    public void getSetGo() /*we have to define "getSetGo()" method here par ye to interface me declare hui thi jisko
                             "Vehicle3_93_1" ne inherit kiya tha, to hame yaha kyu define karni padi?
                             ham waha bhi definition de sakte hai yadi ham chahe to wo abstract defined hai fir bhi
                             waha ham interface ki method de sakte the, lekin ye child hai uska to ham waha na deke
                             yaha bhi de kate hai, if we want to keep that class ki waha bhi abstraction bana rahe.*/

    {

    }
}