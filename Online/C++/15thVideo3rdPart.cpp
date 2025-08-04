//FORMAL PARAMETERS & ACTUAL PARAMETERS:

#include<iostream>
using namespace std;
int sum(int a,int b) /*Here "a" & "b" are FORMAL PARAMETERS as they are not actually used in the
                       programm as an actual variable, they are just here tu ecxpain the compiler*/
{
    int c=a+b;
    return c;
}             
int main()
{
    int num1,num2;
    cout<<"Enter the value of first number: ";
    cin>>num1;
    cout<<"Enter the value of second number: ";
    cin>>num2;
    cout<<"Sum of both the numbers is :"<<sum(num1,num2); /* Here "num1" & "num2" are
                                                             ACTUAL PARAMETERS as they are
                                                             actually used as variables in 
                                                             the programm*/
    return 0;
}