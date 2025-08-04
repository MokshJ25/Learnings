//BASIC INPUT OUTPUT

#include<iostream>
using namespace std;
int main()
{
    int a,b;
    cout<<"Enter the value of a: "; /* "<<" this is an operator and is called INSERTION OPERATOR
                                       because it conveys that jo bhi output dena hai use screen par insert kar do.
                                       "cout" is used for giving outputs*/   
    cin>>a; /* ">>" this is also an operator and is called EXTRACTION OPERATOR
               because it conveys that jo bhi input dia ja raha hai screen par use extract kar lo.
               "cin" is used for taking inputs*/
    cout<<"\nEnter the value of b: ";
    cin>>b;
    cout<<"The sum of a and b is: "<<a+b;
    
    return 0;
}
