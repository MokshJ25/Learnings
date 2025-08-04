// ARRAY & POINTERS:

#include<iostream>
using namespace std;
int main()
{
    int marks[4]={23,45,455,89};
    int* p=marks;
    cout<<"The value at marks[0] or *(p) is:"<<*p<<endl;
    cout<<"The value at marks[1] or *(p+1) is:"<<*(p+1)<<endl;
    cout<<"The value at marks[2] or *(p+2) is:"<<*(p+2)<<endl;
    cout<<"The value at marks[3] or *(p+3) is:"<<*(p+3)<<endl;
    return 0;
}