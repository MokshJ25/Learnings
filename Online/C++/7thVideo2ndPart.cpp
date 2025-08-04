//FLOAT, DOUBLE, & LONG DOUBLE LITERALS:

/* IF we have written(given) same value in float and doubleat a same time in a same programm
   in a same function, so how will we or compiler will know at anytime that that particular value
   belongs to float or double ? 
   MEANS: float a=34.4;
          long double b=34.4;
          34.4; // How will we know that this 34.4 belongs to float or long double ?
    
    {BY DEFAULT, DECIMAL WALA LITERAL DOUBLE HOTA HAI
    yadi same number float or double dono me present hai to}

    So in this case, the priority will be given to long double. Float will have less priority.
    Compiler will understand this 34,4 as a long double, so to overcome this confusion and
    making a difference, compiler have made some ease. We can write "34.4f" or "34.4F" for
    entering the value in float {on console, it will give only "34.4" and will not print "f" or "F".
    And same for long double We can write "34.4l" or "34.4L" for entering the value in long double
    {on console, it will give only "34.4" and will not print "l" or "L".}.
    We & compiler can differentiate this by observing the ending letter{"f"/"F" OR "l"/"L"} that 
    this value belongs to float or long double. */

#include<iostream>
using namespace std;
int main()
{
    float a=34.4f;         //or 34.4F // "f" is written to specify that this number is float, dont read as double
    long double b=34.4l;   //or 34.4L // "l" is written to specify that this number is double, dont read aa float
    
                           /*yadi hamko kasi 34.4 value pass karwani hai to hamko f lagana padega yadi hamko 
                             usko as a float pass karana hai to, nahi to wo by default as a double pass ho jaega*/
    cout<<"Size of 34.4 is "<<sizeof(34.4)<<endl;
    cout<<"Size of 34.4f is "<<sizeof(34.4f)<<endl;
    cout<<"Size of 34.4F is "<<sizeof(34.4F)<<endl;
    cout<<"Size of 34.4l is "<<sizeof(34.4l)<<endl;
    cout<<"Size of 34.4L is "<<sizeof(34.4L)<<endl;
    /* "sizeof()" is a keyword in c++ which tells us about the size of memory occupied by anything
       (written inside parenthesis) in terms of BYTES.*/
    return 0;
}

