//RETURN BY REFERENCE

/*EK koi sa jo function hai usme return by reference laga hua hai to wo return karega kisi reference ko.*/

// #include<iostream>
// using namespace std;
// int & swapReferenceVar(int &a, int &b)
// {
//     int temp=a;
//     a=b;
//     b=temp;
//     return a;
// }
// int main()  
// {
//     int x=4,y=5;
//     swapReferenceVar(x,y)=766; /*Hamne function me return a kia hai to pure "swapReferenceVar" ki jagah
//                                  a aa jaega or a is pointing to "x" anf whole "swapReferenceVar" is equal
//                                  to 766 therefore "a" is equal to 766 means "x" is equal to 766.
//                                  Therefore the value of "x" is 766*/
//     cout<<"The value of x is: "<<x<<" The value of y is: "<<y<<endl;
//     return 0;
// }


//SIMPLY:

#include<iostream>
using namespace std;
int a;
int & func()
{
    return a;
}
int main()
{
    func()=10;
    cout<<"a="<<a;
    return 0;
}