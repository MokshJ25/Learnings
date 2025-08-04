//CONTINUE:

/*    CONTINUE: SKIP HERE AND CONTINUE TO NEXT ITERATION.
                Continue is used to skip a particular iteration and continue to the remainig
                portion of that loop. Yani pure loop me "continue" ke baad jo kuch bhi rahega wo us 
                chiz ko skip kar dega or fir se loop ki starting me pohoch ke loop ko continur karega.
      Continue hamari wo wali particular iteration jo chal rahi hoti hai usko rok kar piche bhej deta
      hai or kehta hai ki tum piche jao or piche jake wo dusri(next) wali iteration run karo.*/


#include<iostream>
using namespace std;
int main()
{
    for(int i=0;i<10;i++)
    {
        if(i==2)
        {
            continue;
        }
        cout<<i<<endl;
    }
    return 0;
}