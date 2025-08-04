//BUILD-IN DATATYPES:

/* To print the valuse of GLOBAL VARIABLE in the programm
   {without making an another new function} when the programm
   is dealing with local variable, we can use SCOPE RESOLUTION OPERATOR {"::"}*/
//For example:

//BASIC INPUT OUTPUT

#include<iostream>
using namespace std;
int c = 45; // It is Global variable
int main()
{
    int a,b;
    cout<<"Enter the value of a: "; 
    cin>>a; 
    cout<<"Enter the value of b: ";
    cin>>b;
    c=a+b;
    cout<<"The sum of a and b i.e. c is: "<<c<<endl;
    cout<<"The value of global variable c is "<< ::c; //{"::"} is SCOPE RESOLUTION OPERATOR
    return 0;
    /*ye program output galat de raha hai. Video me same programm hai par global variable
      print ho raha hai, par yaha is program me dono c me same sum wali value hi aa rahi hai*/
}
