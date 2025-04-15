#include <iostream>
#include <deque>
#include <string>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    int n,x;
    cin>>n;
    string s;
    deque<int> de;
    
    for(int i=0; i<n; i++){
        cin>>s;
        if(s=="push_front"){
            cin>>x;
            de.push_front(x);
        }
        else if(s=="push_back"){
            cin>>x;
            de.push_back(x);
        }
        else if(s=="pop_front"){
            if(de.empty()){
                cout<<-1<<'\n';
            }
            else{
                cout<<de.front()<<'\n';
                de.pop_front();
            }
        }
        else if(s=="pop_back"){
            if(de.empty()){
                cout<<-1<<'\n';
            }
            else{
                cout<<de.back()<<'\n';
                de.pop_back();
            }
        }
        else if(s=="size"){
            cout<<de.size()<<'\n';
        }
        else if(s=="empty"){
            if(de.empty()){
                cout<<1<<'\n';
            }
            else{
                cout<<0<<'\n';
            }
        }
        else if(s=="front"){
            if(de.empty()){
                cout<<-1<<'\n';
            }
            else{
                cout<<de.front()<<'\n';
            }
        }
        else if(s=="back"){
            if(de.empty()){
                cout<<-1<<'\n';
            }
            else{
                cout<<de.back()<<'\n';
            }
        }
    }
    return 0;
}