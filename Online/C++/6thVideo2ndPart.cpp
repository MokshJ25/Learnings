//OPERATORS:

#include<iostream>
using namespace std;
int main()
{
    cout<<"Class about Operators"<<endl<<endl;
    cout<<"1.ARITHMETIC OPERATORS: "<<endl<<"Performing mathamatical calculations"<<endl;
    int a=4,b=5;
    cout<<"The valuse of a+b is: "<<a+b<<endl;    
    cout<<"The valuse of a-b is: "<<a-b<<endl;    
    cout<<"The valuse of a*b is: "<<a*b<<endl;    
    cout<<"The valuse of a/b is: "<<a/b<<endl; /*will give zero because an arithmetic operation
                                                 between two integers is an integer, real anser is 0.8.*/
    cout<<"The valuse of a%b is: "<<a%b<<endl;
    cout<<"The valuse of a++ is: "<<a++<<endl; /* since "a" pehle hai to a ki value jo hai wahi rahegi, 
                                                  par next operation ke lie a ki value +1 ho jaegi,
                                                  kyuki "++" baad me lha hua hai.
                                                  It  is called POST INCREMENT operator.*/    
    cout<<"The valuse of a-- is: "<<a--<<endl; /* since "a" pehle hai to a ki value jo hai wahi rahegi, 
                                                  par next operation ke lie a ki value -1 ho jaegi,
                                                  kyuki "--" baad me lha hua hai.
                                                  It is called POST DECREMENT operator.*/    
    cout<<"The valuse of ++a is: "<<++a<<endl; /* "a" ki value jo bhi ho pehle wo +1 hogi or wahi +1 
                                                  value hi print hogi kyuki "++" pehle lga hua hai.
                                                  It is called PRE INCREMENT operator.*/   
    cout<<"The valuse of --a is: "<<--a<<endl; /* "a" ki value jo bhi ho pehle wo +1 hogi or wahi +1 
                                                  value hi print hogi kyuki "++" pehle lga hua hai.
                                                  It is called PRE INCREMENT operator*/
    
    cout<<"HERE ARITHMETIC OPERATORS IS OVER"<<endl<<endl<<endl<<endl;

    //_______________________________________________________________________
   
    cout<<"2.ASSIGNMENT OPERATORS:"<<endl<<"Assign values to variables"<<endl;
    /* =    : Equals to {Assignment operator}
       +=   : Addition Assignment operator   --> x = x+3
       -=   : Subtraction Assignment operator --> x = x-3
       *=   : Multiplication Assignment operator --> x = x*3
       /=   : Division Assignment operator --> x = x/3
       %=   : Modulus Assignment operator --> x = x%3
       &=   : Assignment operator --> x = x&3
       |=   : Assignment operator --> x = x|3
       ^=   : Assignment operator --> x = x^3
       >>=  : Assignment operator --> x = x>>3
       <<=  : Assignment operator --> x = x<<3 */

    cout<<"HERE ARITHMETIC OPERATORS IS OVER"<<endl<<endl<<endl<<endl;
    
    //_______________________________________________________________________
   
    cout<<"3.COMPARISION/ASSIGNMENT OPERATORS:"<<endl<<"Used to compare the numbers"<<endl;
    cout<<"Following are the comparision operators:"<<endl;
    //The answers will be in the form of true or false i.e. "1" or "0" respectively.
    cout<<"The value of a==b is "<<(a==b)<<endl;
    cout<<"The value of a!=b is "<<(a!=b)<<endl;
    cout<<"The value of a>b is "<<(a>b)<<endl;
    cout<<"The value of a<b is "<<(a<b)<<endl;
    cout<<"The value of a>=b is "<<(a>=b)<<endl;
    cout<<"The value of a<=b is "<<(a<=b)<<endl;
    cout<<"HERE COMPARISION OPERATORS IS OVER"<<endl<<endl<<endl<<endl;
    
    //_______________________________________________________________________
   
    cout<<"4.LOGICAL OPERATORS:"<<endl<<"Determines the logic"<<endl;
    cout<<"Following are the logical operators:"<<endl;
    //The answers will be in the form of true or false i.e. "1" or "0" respectively.
    //It always contains conditions.
    //It is always used with COMPARISION OPERATORS
    /*
      logical AND:                    |      logical OR:                   |    logical NOT: 
      CON. 1    CON. 2    OUTPUT      |      CON. 1    CON. 2    OUTPUT    |    CON.1    OUTPUT
        1         1         1         |         1         1         1      |      1        0
        1         0         0         |         1         0         1      |      0        1
        0         1         0         |         0         1         1      |
        0         0         0         |         0         0         0      |
        NOTE: LOGICAL NOT IS USED WITH SINGLE CONDITION, WHILE OTHER TWO CAN BE USED WITH MULTI CONDITION.*/   
    cout<<"The value of this 'logical AND' operator ((a==b)&&(a<b)) is: "<<((a==b)&&(a<b))<<endl;
    cout<<"The value of this 'logical OR' operator ((a==b)||(a<b)) is: "<<((a==b)||(a<b))<<endl;
    cout<<"The value of this 'logical NOT' operator (!(a==b)) is: "<<(!(a==b))<<endl;
    cout<<"HERE LOGICAL OPERATORS IS OVER"<<endl<<endl<<endl<<endl;
    
    //_______________________________________________________________________
   
    cout<<"5.BITWISE OPERATORS:"<<endl;
    cout<<"Converts the number into binars and then performs bit bybit operations"<<endl;
    cout<<"NOT TAUGHT IN THIS VIDEO.";

    return 0;
}

/* For making more than one cursor(the black blinkig line,which shows
   you are typing): hold alt key + click on the places where you want 
                    to create the cursor.*/