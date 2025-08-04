//FUNCTIONS:

#include<iostream>
using namespace std;
int sum(int a,int b)  // HERE IN THESE LINES, WE HAVE DEFINED A FUNCION ACCORDING TO OUR USE NAMED
{                     // "SUM" AND WE CAN CALL IT IN OUR PROGRAMM TO PERFORM THE SEPECIFIC TASK
    int c=a+b;        // DEFINED IN IT.
    return c;      /* // Yaha par ham jo bhi value "return" karte hai (at the end of our function)
                      // wo value hamare programm me replace hoti hai jab bhi ham wo funcion
                         jis bhi jagah programm me call karte hai tab. Jaise in 21th line we
                         have called this function to jaha hamne "sum(num1,num2)" likha hai
                         waha "c" replace ho raha hoha kyuki hamne yaha return me "c" dala hai*/
}             
int main() // It is also a pre defined function.
{
    int num1,num2;
    cout<<"Enter the value of first number: ";
    cin>>num1;
    cout<<"Enter the value of second number: ";
    cin>>num2;
    cout<<"Sum of both the numbers is :"<<sum(num1,num2); /*Here we have called the funcion "sum" which
                                                            we heave defined earlier.*/
    return 0;
}