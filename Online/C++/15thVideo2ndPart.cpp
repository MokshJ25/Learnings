//FUNCTION PROTOTYPING:

/* Yah pehle hi compiler ko batata hai ki ye function programm me aane wala hai, ye use hone wala hai,
   ye function me ye ye value le kar ye ye value return karne wala hai. Is wajah se compiler
   pehle hu ready ho jata hai un funcrtions ko execute karne ke lie.*/

/* STNTAX:
           type function-name(arguments);*/
#include<iostream>
using namespace std;
int sum(int a,int b); /*Is jagah hamne function prototyping di {yani function ka ek model
                        ya prototype banaya} or compiler ko pehle hi ready kar dia ki ek
                        "sum" naam ka function programm me use hone wala hai. Ye karne ke baad
                        ham programm me kahi bhi wo function ko define kar sakte hai, aisa
                        compulsion nahi rehta hai ki starting me ya programm me us function ko
                        use karne ke pehle hi hame wo function define karna hai. compiler pure
                        programm me se kahi se bhi wo defined function dund kar le aata hai bhale
                        hai bhale hi fir baad me wo function define karo. */
//int sum(int a, int b); //---> Acceptable/correct
//int sum(int a,b); //---> Not Acceptable/Incorrect {dono me datatype define karna is compulsory}
//int sum(int,int); //--->Acceptable/correct*/
void g(void);
//void g(void);//---> Acceptable/correct
//void g();     //---> Acceptable/correct
int main()
{
    int num1,num2;
    cout<<"Enter the value of first number: ";
    cin>>num1;
    cout<<"Enter the value of second number: ";
    cin>>num2;
    cout<<"Sum of both the numbers is :"<<sum(num1,num2)<<endl;
    g();
    return 0;
}
int sum(int a,int b)
{                     
    int c=a+b;        
    return c;
}
void g() 
{
    cout<<"Hello, GOOD MORNING";
} /* baar baar cout de de kar thak gae hai to ye aise bhi ek function define kar sakte hai.
     programm me sirf "g()" likho or pura function call ho jaega.*/
