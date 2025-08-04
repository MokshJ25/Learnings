//HOW TO MAKE SNIPPET.
//BREAKS & CONTINUE:

/* 1. BREAK: Break is used to cut down the flow of loop or break the loop and come out of the loop
          and perform the other activity given in that code instead of workin in that loop.
   2. CONTINUE: Continue is used to skip a particular iteration and continue to the remainig
                portion of that loop. Yani pure loop me "continue" ke baad jo kuch bhi rahega wo us 
                chiz ko skip kar dega or fir se loop ki starting me pohoch ke loop ko continur karega.*/

//BREAKS:

#include<iostream>
using namespace std;
int main()
{
    for(int i=0;i<10;i++)
    {
        cout<<i<<endl;
        if(i==2)
        {
            break;
        }
    }
    return 0;
}
/* It will give output: 0
                        1
                        2
_________________________________

    for(int i=0;i<10;i++)
    {
        
        if(i==2)
        {
            break;
        }
        cout<<i<<endl;
    } 
   But the above code will give output: 0
                                        1 */