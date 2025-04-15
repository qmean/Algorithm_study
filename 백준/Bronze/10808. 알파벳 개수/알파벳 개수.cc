#include <iostream>
#include <string>

using namespace std;

int main()
{
    string s;
    cin>>s;
    int al[26];
    
    for(int i=0; i<26; i++){
        al[i]=0;
    }
    
    for(int i=0; i<s.size(); i++){
        al[static_cast<int>(s.at(i))-97]++;
    }
    
    for(int i=0; i<26; i++){
       cout<<al[i]<<' ';
    }
    
    return 0;
}
