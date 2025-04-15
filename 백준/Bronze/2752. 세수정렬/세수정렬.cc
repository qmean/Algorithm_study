
#include <iostream>

using namespace std;

int main()
{
    int a[3];
    int b;
    int max,min,mid;
    for(int i=0; i<3; i++){
        cin>>b;
        a[i]=b;
    }
    max=a[0]; 
    min=a[0];
    mid=a[0];
    for(int i =0; i<3; i++){
        if(a[i]>max){
            max=a[i];
        }
        if(a[i]<min){
            min=a[i];
        }
        
    }
    for(int i=0; i<3; i++){
        if(a[i]<max&&a[i]>min){
            mid=a[i];
        }
    }
    
    cout<<min<<" "<<mid<<" "<<max;
    return 0;
}
