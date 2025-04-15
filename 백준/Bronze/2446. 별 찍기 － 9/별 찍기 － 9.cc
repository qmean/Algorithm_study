#include <iostream>

using namespace std;

int main()
{
    int a;
    
    cin>>a;
    
    for(int i=0; i<2*a-1; i++){
        if(i<a){
            for(int k=0; k<i; k++){
                cout<<' ';
            }
            for(int j=0; j<2*a-2*i-1; j++){
                cout<<'*';
            }
        }
        else{
            for(int k=0; k<2*a-i-2; k++){
                cout<<' ';
            }
            for(int j=0; j<2*i-2*a+3; j++){
                cout<<'*';
            }
        }
        
        cout<<"\n";
    }
    
    return 0;
}