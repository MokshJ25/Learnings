//ENUM

/* We can give integer value (starting from 0) to the itnems declared under enum*/

#include<iostream>
using namespace std;
int main()
{
    enum meal{breakfast,lunch,dinner}; /* we have written "enum meal" so "meal" has become a datatype for
                                          storing enum values.*/
    meal m1=breakfast;
    cout<<breakfast<<endl;
    cout<<lunch<<endl;
    cout<<dinner<<endl;
    cout<<m1<<endl;
    cout<<(m1==1); //here we will get 1 or 0 as per true or false
    return 0;
}