// CONTROL STRUCTURES:

/* It gives a flow and logic to the programm.
   It is of 3 types:
   1. Sequence structures: Works in a sequence.
                           No condition, no true false, just flow in one direction.
   2. Selection structures: Have choises, conditions, and true false.
                            Have to worK on that condition. If that codition is true so work in action 1,
                            otherwise work on action 2, there can be more actions and conditions.
                            And then it comes to an end.
   3. Loop structures: Have choices, conditions, true false, and loops.
                       untill the condition is true, the loop will continue to work. Once the
                       condition will become false, loop will break and will do another action,
                       and the come to an end. */

/* If-else & control structure:
   1. If-else.
   2. If-else ladder.
   3. Switch case.
*/

// {Abhi tak jitne bhi programm banae(1stVideo to 8thVideo) wo Sequence Structure pe based hai.}

//SELECTION CONTROL STRUCTURE: IF-ELSE IF-ELSE IF-ELSE LADDER:
//1. IF ELSE: {if-else is based on selection structure.}
//2. IF ELSE LADDER: {if-else ladder is also based on selection structure.}
#include<iostream>
using namespace std;
int main()
{
    int age;
    cout<<"Enter your age ";
    cin>>age;
    if((age<18)&&(age>0))
    {
        cout<<"You cannot come to party";
    }
    else if (age==18)
    {
        cout<<"You will get a kid pass to the party";
    }
        else if (age<1)
    {
        cout<<"You are not yet born";
    }
    else
    {
        cout<<"You can come to the party";
    }
    return 0;
}
