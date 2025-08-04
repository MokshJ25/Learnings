//CONSTANT VARIABLES IN C++:

/* Kisi bhi variable ki value code me kabhi bhi change ki ja sakti hai. therefore to prevent
   this modification of value, "const" keyword is used before the datatype. This will keep the
   value of that particular variable constant througout the code. And if we will try to change
   the value, it will give error.*/

#include<iostream>
using namespace std;
int main()
{
    int a=5;
    cout<<"Initially the value of a was "<<a<<endl;
    a=10;
    cout<<"The value of a is changed to "<<a<<endl;
    const int b=15; //Value is fixed by "const" keyword
    cout<<"The value of b i.e. "<<b<<" is constant throughout the code";
    //b=16; // This will give error in the code
    return 0;
}