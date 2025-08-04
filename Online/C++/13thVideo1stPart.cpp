// ARRAY:

/* Structure: int marks[2500];
-->It means integer type ka datatype hai jiska naam "marks" hai or iske andar 2500 integer store honge.*/

#include<iostream>
using namespace std;
int main()
{
    int marks[4]={23,24,25,26};
    cout<<"Marks are"<<endl;
    cout<<marks[0]<<endl;
    cout<<marks[1]<<endl;

    marks[2]=27; // You cange the value of an array
    
    cout<<marks[2]<<endl;
    cout<<marks[3]<<endl;

    int MathMarks[4];
    MathMarks[0] = 11;    
    MathMarks[1] = 12;
    MathMarks[2] = 13;
    MathMarks[3] = 14;
    cout<<"Math Marks are:"<<endl;  
    // cout<<MathMarks[0]<<endl;      
    // cout<<MathMarks[1]<<endl;      
    // cout<<MathMarks[2]<<endl;      
    // cout<<MathMarks[3]<<endl;      

    // Array printing using a loop

    for (int i=0;i<4;i++)
    {
        cout<<"The value of Math Marks "<<i<<" is "<<MathMarks[i]<<endl;
    }
    return 0;
}