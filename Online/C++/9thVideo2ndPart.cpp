// SELECTION CONTROL STRUCTURE: SWITCH CASE EXPRESSION:
// 3. SWITH CASE EXPRESSION: {switch case is also based on selection structure.}

#include<iostream>
using namespace std;
int main()
{
    int age;
    cout<<"Enter your age ";
    cin>>age;
    switch(age) //It means "age" jo variable hai usko check karo
    {
        case 18: // Yadi "age ki value "18" ho to given action perform karo
        {
            cout<<"You are 18";
            break; // Agar ye case sahi ho to neeche walo ko bhulo or switch case ke bahar kud jao.
        }
         case 22:
        {
            cout<<"You are 22";
            break;
        } 
        case 2:
        {
            cout<<"You are 2";
            break;
        }
        default:
        {
            cout<<"No special cases";
            break;
        }
    }
    cout<<"Done with switch case";
    return 0;
}