//VARIABLE SCOPE & DATATYPES

#include<iostream>
using namespace std;
int glo=10;
void sum() //here we have made an another function and we will call this function in the programm
{
    cout<<glo<<"\n";
}
int main()
{
    int a=4,b=5,glo=11;
    float pi=3.14;
    char c='a'; 
    bool condition= true; //here condition is nothing but the name of the variable
    cout<<"The value of a is "<<a<<"\n";
    cout<<"The value of b is "<<b<<"\n";
    cout<<"The value of pi is "<<pi<<"\n";
    cout<<"The value of c is "<<c<<"\n";
    cout<<"The value of glo is "<<glo<<"\n";
    sum(); /*here we have called sum function (5th line). or programm me jab bhi ham
             koisa function call karte hai to compiler jaise hi us line pe aata hai
             jis line me hamne wo function call kia hai to programm break hoke compiler
             pehle wo function me jata hai or usko execute karta hai. uske execution
             ke baad hi further programm execute hota hai. */
    cout<<glo<<"\n";
    cout<<condition; // It will give "1" as the result because "true" is treated as 1 and "false" as 0
    return 0;
}

/* "\n" is called ESCAPE SEQUENCE CHARACTER. It changes the line or break the line.
    It is always under double underscore("") or always used under string
    Same as "\n", we can use "endl" to change or break the line on console,
    but unline "\n", "endl" is used without doublrquotes ("").*/


/* char onlY contain single character in it and it is in (''). 
   If we enter more than one character so compiler will print only last letter.*/


/* Both global and local variable can have same name but the local variable will
   take precedence or the priority will be given to the local variable,
   and the value of local variable will get printed.*/


/* compiler jab 19th line pe aaega to sum function  execute kara jaega, waha "cout<<glo"
   likha hua hai. compiler pehle sum function me hi glo ki value dhundega kyuki local
   variable have precedence(priority) par jab compiler ko sum function me glo ki value 
   nahi milegi tab wo jaega global variable ke paas or waha se glo ki value leke aaega.*/