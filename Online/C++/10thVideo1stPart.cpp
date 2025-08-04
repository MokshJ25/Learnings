//LOOPS IN C++:

//Used to perform a task repeteadly.
/* There are 3 types of loops in c++:
   1. FOR LOOP.
   2. WHILE LOOP.
   3. DO WHILE LOOP.*/

// 1. FOR LOOP:

/* SYNTAX for for loop:
        for(initialization;condition;updation)
        {
            LOOP BODY(C++ CODE);
        }
*/

#include<iostream>
using namespace std;
int main()
{
    int i;
    for(i=1;i<=100;i++)
    {
        cout<<i<<endl;
    }
    return 0;

}

/* Example of infinite for loop:
#include<iostream>
using namespace std;
int main()
{
    int i;
    for(i=1;i<=100;i++)
    {
        cout<<i<<endl;
    }
    return 0;

} */
