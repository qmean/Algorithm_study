#include <iostream>
#include <queue>
#include <string>

using namespace std;

int main(){
    std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);
    queue<int> qu;
    int a,x;
    string inp;
    
    cin>>a;
    
    for(int i=0; i<a; i++){
        cin>>inp;
        if(inp=="push"){
            cin>>x;
            qu.push(x);
        }
        else if(inp=="pop"){
            if(qu.empty()){
                cout<<-1<<'\n';
            }
            else{
                cout<<qu.front()<<'\n';
                qu.pop();
            }
        }
        else if(inp=="size"){
            cout<<qu.size()<<'\n';
        }
        else if(inp=="empty"){
            if(qu.empty()){
                cout<<1<<'\n';
            }
            else{
                cout<<0<<'\n';
            }
        }
        else if(inp=="front"){
            if(qu.empty()){
                cout<<-1<<'\n';
            }
            else{
                cout<<qu.front()<<'\n';
            }
        }
        else if(inp=="back"){
            if(qu.empty()){
                cout<<-1<<'\n';
            }
            else{
                cout<<qu.back()<<'\n';
            }
        }
    }
    
    return 0;
}