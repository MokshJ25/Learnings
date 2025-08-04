//CALL BY REFERENCE:

#include<iostream>
using namespace std;
//THIS WILL NOT SWAP A & B
void swap(int a, int b)
{
    int temp =a;
    a=b;
    b=temp;
/* Yaha par x or y as it is aise hi programm se copy ho kar aa gae hai, uska koi significance nahi hai.
   function run to hoga par run hone ke baad destroy ho jaega. koi matlab nahi niklega iska.*/
}

//----------------------------------------------------------------------------------------

//CALL BY REFERENCE USING POINTERS
void swapPointer(int* a, int* b)
{
    int temp =*a; //"temp" is equal to value at address "a"
    *a=*b;        //value at address "a" is equal to  value at address "b"
    *b=temp;      //value at address "b" is equal to "temp"
/* Yaha hamne value at address hi change kar di hai to obviously programm me variables ka jo address
   par jo value hai wo bhi change hogi hi*/
}

//-----------------------------------------------------------------------------------------

//CALL BY REFERENCE USING C++ REFERENCE VARIABLES  {7th Video}
void swapReferenceVar(int &a, int &b) 
{
    int temp = a; //"temp" is equal to value at address "a"
    a= b;         //value at address "a" is equal to  value at address "b"
    b=temp;       //value at address "b" is equal to "temp"
/* Yaha "a" point karega "x" ko memory me or "b" karega "y" ko memory me islie
   values will be swapped again.*/
}

//-----------------------------------------------------------------------------------------

int main()
{
    int x=4,y=5;
    cout<<"The value of x is: "<<x<<" The value of y is: "<<y<<endl<<endl<<endl;
    swap(x,y);//THIS WILL NOT SWAP A & B
    cout<<"The value of x is: "<<x<<" The value of y is: "<<y<<endl;
    swapPointer(&x,&y);//CALL BY REFERENCE USING POINTERS//This will swa a & b using pointer reference 
    cout<<"POINTER REFERENCE\nThe value of x is: "<<x<<" The value of y is: "<<y<<endl;
    swapReferenceVar(x,y);//This will swap a & b using reference variables
    cout<<"REFERENCE VARIABLE\nThe value of x is: "<<x<<" The value of y is: "<<y;
    return 0;
}