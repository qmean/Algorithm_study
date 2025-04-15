#include <iostream>
#include <queue>
#include <string>

using namespace std;

int main(){
    queue<int> qu;
    int a;
    string inp;
    
    cin>>a;
    
    for(int i=0; i<a; i++){
        cin>>inp;
        if(inp=="push"){
            int x;
            cin>>x;
            qu.push(x);
        }
        else if(inp=="pop"){
            if(qu.empty()){
                cout<<-1<<endl;
            }
            else{
                cout<<qu.front()<<endl;
                qu.pop();
            }
        }
        else if(inp=="size"){
            cout<<qu.size()<<endl;
        }
        else if(inp=="empty"){
            if(qu.empty()){
                cout<<1<<endl;
            }
            else{
                cout<<0<<endl;
            }
        }
        else if(inp=="front"){
            if(qu.empty()){
                cout<<-1<<endl;
            }
            else{
                cout<<qu.front()<<endl;
            }
        }
        else if(inp=="back"){
            if(qu.empty()){
                cout<<-1<<endl;
            }
            else{
                cout<<qu.back()<<endl;
            }
        }
    }
    
    return 0;
}