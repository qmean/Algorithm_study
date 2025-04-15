#include <iostream>

using namespace std;

int main()
{
    long long int a,b,c;
    long long int min,max;
    cin>>a>>b;
    min=a;
    max=b;
    if(b<min){
        min=b;
        max=a;
    }
    
    if(min==max){
        c=0;
    }
    else{
        c=max-min-1;
    }
    
    cout<<c<<endl;
    
    for(long long int i=1; i<=c; i++){
        cout<<min+i<<' ';
    }
    
    return 0;
}
