//REFERENCE VARIABLES: 

/* If we want to give more than one name to the same variable
   {jaise ek insaan kae ek se zyada naam ho sakte hai in the same way variables can
    also have more than one name} we use reference variable.*/


/* we use "&" symbol, called as "AMPERSAND SYMBOL". In c++, ampersand,&, is used as a
   reference declaration in addition to being the address operator. {"&" is used to
   declare a reference to a type}*/

#include<iostream>
using namespace std;
int main()
{
    float a=455;
    float &b=a; // yaha "b" ek reference variable ban chuka hi a ka. Ab me "a" ko "a" kahu ya "b" wo rahega 455 hi.
    cout<<a<<endl<<b;
    return 0;
}