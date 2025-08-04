//MANIPULATORS IN C++:

/* Ye wo operators hai jo hamare data display ki formatting me help karte hai, yani wo display kaisa
   ho raha hai, kaha line break ho rahi hai, kaha kitni space aa rahi hai, un sab me madad karta hai.
   In simple words, it manipulates our data on cosole, that how it will look.
   
   1. "endl": It is a type of manipulator and it breaks the line.
   2. "setw": used to set the FEILDWEIDTH.
              It is a type of manipulator used with "iomanip"{i:input, o:output, manip:manipulator}
              named header file, we have to call this header file before using setw.
              It is used in the same way how endl is used but its work is differen.
              Its work is to reserve the space. Suppose we have set "setw(4)", it means that save
              space for 4 letters. If our output is "1" and we have "setw(4)" so initial 3 spaces
              will get reserved and 1 will get printed in 4th space. {"___1"}.  */

#include<iostream>
#include<iomanip> // "setw" manipulator is present in this header file. So to use setw, we have to call this
using namespace std;
int main()
{
    int a=1,b=12,c=123,d=1234;
    cout<<"The value of a without 'setw' is "<<a<<endl;
    cout<<"The value of b without 'setw' is "<<b<<endl;
    cout<<"The value of c without 'setw' is "<<c<<endl;
    cout<<"The value of d without 'setw' is "<<d<<endl;
    cout<<"The value of a wit 'setw' is "<<setw(4)<<a<<endl;
    cout<<"The value of b wit 'setw' is "<<setw(4)<<b<<endl;
    cout<<"The value of c wit 'setw' is "<<setw(4)<<c<<endl;
    cout<<"The value of d wit 'setw' is "<<setw(4)<<d<<endl;
    return 0;
}