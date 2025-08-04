class Driver6
{
    public static void main(String[] args)
    {

        Car6 swift= new Car6("Red"); /* yaha pehli baar "Car6" dikhega to "Car6" naam ki class ko pehli
                                              baar load karega tab, just for one and last time pehli baar static
                                              code block chalega. fir new object bnane ke lie "Car6()" constructor
                                              encounter hoga uske pehle Initialization block load karega*/
        System.out.println(swift.color); // fir ye obj. banega tab yaha object ne attribute access kia hai wo chalega

        Car6 thar=new Car6(); /* firse yaha "Car6" class se takraega par yaha Static code block load nahi karega
                                 kyuki wo code ke execution  me usne ek baar shuru me hi static block call kar dia hai.
                                 fir ye "Car6" constructor se encounter hoga tab ye naya object firse banaega par
                                 constructor load karne ke pehle firse ye Initialization code block call karega.*/
        System.out.println(thar.color); // fir ye obj. banega tan yaha object ne attribute access kia hai wo chalega
    }
}
