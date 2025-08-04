//STRUCTURES

#include<iostream>
using namespace std;
typedef struct employee
{
    int eID;
    char FavChar;
    float salary;
} ep;
int main()
{

    struct employee harry;
    struct employee shubham;
    struct employee rohan;
    harry.eID=1;
    harry.FavChar='c';
    harry.salary=120000000;
    cout<<"The eID of harry is:"<<harry.eID<<endl;
    cout<<"The Favoutire Character of harry is:"<<harry.FavChar<<endl;
    cout<<"The Salary of harry is:"<<harry.salary<<endl;
    return 0;
}




/*

#include<iostream>
using namespace std;
typedef struct employee  //"typedef" is used to create shortcut names of any long user defined datatype
{
    int eID;
    char FavChar;
    float salary;
} ep;                    //here "ep" is the shortcut we creater for "struct employee"
int main()
{
    ep harry;
    ep shubham;
    ep rohan;
    harry.eID=1;
    harry.FavChar='c';
    harry.salary=120000000;
    cout<<"The eID of harry is:"<<harry.eID<<endl;
    cout<<"The Favoutire Character of harry is:"<<harry.FavChar<<endl;
    cout<<"The Salary of harry is:"<<harry.salary<<endl;
    return 0;
}*/