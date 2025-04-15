#include <iostream>

using namespace std;

int main()
{
    int a,b,c;
    int max;
    
    cin>>a>>b>>c;
    
    max=a;
    
    if(max<b){
        max=b;
    }
    if(max<c){
        max=c;
    }
    
    
    if(a==b){
        if(b==c){
            //3
            cout<<10000+a*1000;
        }
        else{
            //2
            cout<<1000+a*100;
        }
    }
    else{
        if(b==c){
            //2
            cout<<1000+b*100;
        }
        else{
            if(a==c){
                //2
                cout<<1000+a*100;
            }
            else{
                //0
                cout<<max*100;
            }
        }
    }
}