//HEADER FILES & OPERATORS
// HEADER FILES:

 /* To know aout a header file: press ctrl and click on that header file.
    After doint this, all the information about the header file will be visible.
    And before line 1, you can see the pathway to that header file. */   

/* There are two types of header files:
   1. System Header File: It comes with the compiler. Ex.: iostream
   2. User Defined Header File: It is written by the programmer. 
      Ex.: #include "sixthVideo.h"  
      Here sixthVideo.h is a header file and this will produce an error 
      if this header file (sixthVideo.h) is not present in the current directory.
      NOTE: The naming of the user defined header file have the same rules as naming of variables. */

#include<iostream>
#include "SixthVideo.h" // This will produce erroe if SixthVideo.h is not present in the current directory
using namespace std;
int main()
{
    cout<<"Class About Header Files"<<endl<<"{Check for 'endl' keyword}";
    return 0;
}

    /* Same as "\n", we can use "endl" to change or break the line on console,
       but unline "\n", "endl" is used without doublrquotes (""). */