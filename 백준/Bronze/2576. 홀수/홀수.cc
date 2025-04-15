#include <iostream>

using namespace std;



int main()
{
    int a[7];
    int sum=0;
    int min=100;
    
    for(int i=0; i<7; i++){
        cin>>a[i];
    }
    
    
    for(int i=0; i<7; i++){
        if(a[i]%2!=0){
            //홀수
            sum=sum+a[i];
            if(min>a[i]){
                min=a[i];
            }
        }
    }
    
    if(sum==0){
        cout<<-1;
    }
    else{
        cout<<sum<<endl<<min;
    }
    
    
    
    
    return 0;
}