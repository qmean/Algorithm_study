#include <iostream>
#include <string>

using namespace std;

int main()
{
    int a,b,c;
    cin>>a;
    int al[a];
    
    for(int i=0; i<a; i++){
        cin>>al[i];
    }
    c=0;
    cin>>b;
    
    for(int i=0; i<a; i++){
        if(al[i]==b){
            c++;
        }
    }
    
    cout<<c;
    
    return 0;
}
