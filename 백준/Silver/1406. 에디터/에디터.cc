#include <iostream>
#include <string>
#include <list>

using namespace std;

int main(void) {
    string s;
    int n;
    cin>>s>>n;
    list<char> L;
    for(int i=0; i<s.size(); i++){
        L.push_back(s.at(i));
    }
    list<char>::iterator iter = L.end();
    
    char com;
    for(int i=0; i<n; i++){
        cin>>com;
        switch(com){
            case 'L':
            {
                if(iter!=L.begin()){
                    iter--;
                }
                break;
            }
            case 'D':
            {
                if(iter!=L.end()){
                    iter++;
                }
                break;
            }
            case 'B':
            {
                if(iter!=L.begin()){
                    iter--;
                    iter = L.erase(iter);
                }
                break;
            }
            case 'P':
            {
                char c;
                cin>>c;
                L.insert(iter,c);
                break;
            }
        }
    }
    
    for(auto i : L){
        cout<<i;
    }
    
    return 0;
  
}