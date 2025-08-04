// TYPECASTING:

/* Typecasting is to convert datatype of one variable into another datatype
   Means suppose we have "a" as int and we have to convert it into float, so there
   we will use typecasting.*/

/* Ye tab use hota hai jan hame kisi decimal number ki integer value ki hi zarurat ho
   or us integer value se hi operations perform karana ho. */

   
#include<iostream>
using namespace std;
int main()
{
    int a=45;
    float b=45.46;
    cout<<"The TYPECASTED value of a is "<<(float)a<<endl; //"(float)a"  can also be written as "float(a)"
    cout<<"The TYPECASTED value of b is "<<int(a)<<endl;   //"int(a)"  can also be written as "(int)a"

    cout<<"The ecpression 'a+b' gives "<<a+b<<endl;            //90.46
    cout<<"The ecpression 'a+int(b)' gives "<<a+int(b)<<endl;  //90
    cout<<"The ecpression 'a+(int)b' gives "<<a+(int)b<<endl;  //90
    return 0;
}