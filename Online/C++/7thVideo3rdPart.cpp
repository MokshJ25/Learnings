//SIZE OF DATATYPES :

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
    return 0;
}

/* "sizeof()" is a keyword in c++ which tells us about the size of memory occupied by anything
   (written inside parenthesis) in terms of BYTES.*/

/*  SIZE OF DIFFERENT DATATYPES IN A 64 BIT SYSTEM :

    Size of CHAR = 1 BYTES
    Size of INT = 2 OR 4 BYTES
    Size of FLOAT = 4 BYTES
    Size of DOUBLE = 8 BYTES
    Size of BOOLEAN = 1 BYTES
    Size of SHORT = 2 BYTES
    Size of LONG = 4 BYTES
    Size of LONG LONG = 8 BYTES
    Size of LONG DOUBLE = 12 BYTES    */


/* //DATATYPE SIZE CHECKER:
    #include<iostream>
    using namespace std;
    int main()
    {
        int a;
        bool b;
        char c;
        double d;
        short e;
        float f;
        long g;
        long long h;
        long double i;
        cout<<"int "<<sizeof(a)<<"Bytes"<<endl;
        cout<<"bool "<<sizeof(b)<<"Bytes"<<endl;
        cout<<"char "<<sizeof(c)<<"Bytes"<<endl;
        cout<<"double "<<sizeof(d)<<"Bytes"<<endl;
        cout<<"short "<<sizeof(e)<<"Bytes"<<endl;
        cout<<"float "<<sizeof(f)<<"Bytes"<<endl;
        cout<<"long "<<sizeof(g)<<"Bytes"<<endl;
        cout<<"long long "<<sizeof(h)<<"Bytes"<<endl;
        cout<<"long double "<<sizeof(i)<<"Bytes"<<endl;
        return 0;
    }*/