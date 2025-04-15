#include <iostream>

using namespace std;

int main()
{
    int n,max,min,inp;
    cin>>n;
    
    for(int i=0; i<n; i++){
        cin>>inp;
        if(i==0){
            max=inp;
            min=inp;
        }
        else {
            if(max<inp){
                max=inp;
            }
            if(inp<min){
                min=inp;
            }
        }
    }
    cout<<min<<" "<<max;
    return 0;
}