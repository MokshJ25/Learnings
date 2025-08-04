//PRINTING ARRAYS USING LOOPS

 #include<iostream>
 using namespace std;
 int main()
 {
    int MathMarks[4]={11,12,13,14};
    //USING FOR LOOP
    cout<<"USING FOR LOOP"<<endl;
     for (int i=0;i<4;i++)
    {
        cout<<"The value of Math Marks "<<i<<" is "<<MathMarks[i]<<endl;
    }

    //USING WHILE LOOP
    cout<<"USING WHILE LOOP"<<endl;
    int ChemMarks[4]={21,22,23,24},j=0;
    while(j<4)
    {
        cout<<"The value of Chemistry Marks "<<j<<" is "<<ChemMarks[j]<<endl;
        j++;
    }

    //USING DO WHILE LOOP
    cout<<"USING DO WHILE LOOP"<<endl;
    int PhyMarks[4]={31,32,33,34},k=0;
    do
    {
        cout<<"The value of Physics Marks "<<k<<" is "<<PhyMarks[k]<<endl;
        k++;
    }
    while(k<4);
    return 0;
 }
