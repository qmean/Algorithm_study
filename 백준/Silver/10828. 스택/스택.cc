#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main()
{
    stack<int> stk;
    int n;
    cin>>n;
    string s;
    
    for(int i=0; i<n; i++){
        cin>>s;
        if(s=="push"){
            int x;
            cin>>x;
            stk.push(x);
        }
        else if(s=="pop"){
            if(stk.empty()){
                cout<<-1<<endl;
            }
            else{
                cout<<stk.top()<<endl;
                stk.pop();
            }
        }
        else if(s=="size"){
            cout<<stk.size()<<endl;
        }
        else if(s=="empty"){
            if(stk.empty()){
                cout<<1<<endl;
            }
            else{
                cout<<0<<endl;
            }
        }
        else if(s=="top"){
            if(stk.empty()){
                cout<<-1<<endl;
            }
            else{
                cout<<stk.top()<<endl;
            }
        }
    }
    
    return 0;
}