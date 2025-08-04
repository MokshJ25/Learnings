//UNION


#include<iostream>
using namespace std;
union money  /* Aage chal ke ham in teeno datatypes me se ek hi use kar payenge, because we used union
                or union memory sare karta hai.*/
{
    int rice;
    char car;
    float pound;
};
int main()
{
    union money m1;
    m1.rice=31;
    //m1.car='c';  // the value will be overrighted and we will get garbage value in output
    //cout<<m1.car;// but here instead of "m1.rice" if i have written "m1.car" so i would have get
                   // correct value kyuki abhi "m1.rice" ke baad me "m1.car" likha hua hai or uske
                   // just baad cout banaya hua hai, to value abhi overrighted nahi hai.
    cout<<m1.rice;
    return 0;
}