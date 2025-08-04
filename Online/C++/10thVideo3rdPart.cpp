//  DO WHILE LOOP:

/* SYNTAX:
     do
     {
        C++ STATEMENTS;
     }
     while(conditions);
     */

#include<iostream>
using namespace std;
int main()
{
    int i=1;
    do
    {
        cout<<i<<endl;
        i++;
    }
    while(i<=40);
    return 0;
}

/* Example of infinite while loop:
#include<iostream>
using namespace std;
int main()
{
    int i;
    do
    {
        cout<<i<<endl;
        i++;
    }
    while(true);
    return 0;

} */


/*ASSIGNMENT: PRINT A MULTIPLICATION TABLE USING ANY LOOP.
SOLUTION: USING DO WHILE LOOP.
#include<iostream>
using namespace std;
int main()
{
    int i=1,a,b;
    cout<<"Enter the number whose table is to be printed: ";
    cin>>a;
    do
    {
        b=a*i;
        cout<<b<<endl;
        i++;
    }
    while(i<=10);
    return 0;
}
*/
