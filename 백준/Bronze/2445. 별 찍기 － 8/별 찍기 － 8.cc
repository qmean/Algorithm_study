#include <iostream>

using namespace std;

int main()
{
    int a;
    
    cin>>a;
    
    for(int i=0; i<2*a-1; i++){
        if(i<a){
            for(int k=0; k<i+1; k++){
                cout<<'*';
            }
            for(int j=0; j<2*(a-i-1); j++){
                cout<<' ';
            }
            for(int k=0; k<i+1; k++){
                cout<<'*';
            }
        }
        else{
            for(int k=0; k<2*a-i-1; k++){
                cout<<'*';
            }
            for(int j=0; j<2*(i-a+1); j++){
                cout<<" ";
            }
            for(int k=0; k<2*a-i-1; k++){
                cout<<'*';
            }
        }
        
        cout<<"\n";
    }
    
    return 0;
}