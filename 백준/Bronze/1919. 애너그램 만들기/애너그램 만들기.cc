#include <iostream>
#include <string>

using namespace std;

int main()
{
    
    string pr[2];
    int al[2][26];
    int b=0;
    
    cin>>pr[0]>>pr[1];
    
    for(int i=0; i<26; i++){
        al[0][i]=0;
        al[1][i]=0;
    }
    
    for(int i=0; i<pr[0].size(); i++){
        al[0][pr[0].at(i)-97]++;
    }
    for(int i=0; i<pr[1].size(); i++){
        al[1][pr[1].at(i)-97]++;
    }
    
    for(int i=0; i<26; i++){
        if(al[0][i]>al[1][i]){
            b=b+al[0][i]-al[1][i];
        }
        else if(al[0][i]<al[1][i]){
            b=b+al[1][i]-al[0][i];
        }
    }
    
    cout<<b;

    return 0;
}