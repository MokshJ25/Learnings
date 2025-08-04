// POINTERS:

/* Pointer is a DATATYPE which holds the address of variables of other datatypes.
   If we put "*" after the name of any datatype {Ex. "int*"}, it becomes a pointer datatype.
   "int*" means the pointer which points on interger datatype.
   Ex. int a=3;
       int* b=&a;
   {"&"=Address of datatype
    "*"=Dereference operator}
    
NOTE: KISI BHI PROGRAMM ME VARIABLES RAM ME STORE HOTE HAI.
{jab ham koi programm run karte hai to code phle RAM me copy hota hai or us program me jo bhi variables
 hote hai unko us RAM me address dia jata hai ki wo puri memory me ki jagah store honge.}*/


#include<iostream>
using namespace std;
int main()
{
    int a=3;
    int* b=&a;

    //"&" = (Address of) operator.
    cout<<"The address of a is "<<b<<endl;
    cout<<"The address of a is "<<&a<<endl;
    
    //"*" = (Value at) Dereferencing operator.
    cout<<"The value at address b is "<<*b<<endl; /* "b" is "&a" means b holds address of a, simply,
                                                     "b" IS ADDRESS OF "a" and "*" means VALUE AT,
                                                     therefore "*b" means VALUE AT ADRESS OF "a".
                                                     therefore "*b" will give value which is stored
                                                     at that address.*/
    // POINTER TO POINTER
    /* Ek aisa pointer banana jo kisi pointer variable ka address store kare.
       int a=3;
       int* b=&a; ---> "a" ka address to "b" ne bata dia par "b" variable ka bhi to ek address hoga,
                       wo bhi to memory me kahi store hoga kisi address par, to wo "b" ka address
                       bhi ek pointer bataega & that variable jo ek pointer variable ka address
                       bataega that is called pointer to pointer variable.*/
    int** c=&b; // "int**" is pointer to pointer and "c" is pointer to pointer variable.
    cout<<"The address of b is "<<&b<<endl;
    cout<<"The address of b is "<<c<<endl;
    cout<<"The value at address c is "<<*c<<endl;  /* "c" is "&b" means c holds address of b, simply,
                                                     "c" IS ADDRESS OF "b" and "*" means VALUE AT,
                                                     therefore "*c" means VALUE AT ADDRESS OF "b" and
                                                     value of b is address of "a".
                                                     therefore "*c" will give value which is stored
                                                     at "b" i.e. address of "a".*/
    cout<<"The value at address value_at(value_at(c)) is "<<**c<<endl; /* "*c"= value at address of b
                                                                                i.e. address of a.
                                                                          "**c"= value at value at
                                                                                 address of b
                                                                          i.e. value at address of 
                                                                          b is address of a, and
                                                                          value at address of a is
                                                                          "3".*/
    return 0;
}

/* YADI KOI DATATYPE KE BAAD "*" LAGA DO TO USKE ANDAR JO BHI VARIABLE DECLARE HONGE WO
   POINTER VARIABLE HOGA WO KISI NORMAL DATATYPE KE VARIABLE KA ADDRESS STORE KARENGE.
   PAR YADI US POINTER VARIABLE KE PEHLE "*" LAGA DO(print karate waqt) TO US POINTER VARIABLE NE
   JO ADDRESS STORE KARKE RAKHA HUA HAI, US ADDRESS PE KYA VALUE HAI, WO PRINT HO JAEGI.*/

/* KISI VARIABLE KE AAGE "&" LAGA DO TO KISI POINTER ME DALNE KE LIE ADDRESS MIL JATA HAI.
   OR KISI POINTER VARIABLE KE AAGE "*" LAGA DO TO US ADDRESS PAR VALUE MIL JATI HAI*/