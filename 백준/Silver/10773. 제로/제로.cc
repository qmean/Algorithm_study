#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main()
{
    stack<int> stk;
    int n;
    cin>>n;
    int j;
    
    for(int i=0; i<n; i++){
        cin>>j;
        
        if(j==0){
            stk.pop();
        }
        else{
            stk.push(j);
        }
    }
    
    int sum=0;
    
    int k=stk.size();
    for(int i=0; i<k; i++){
        sum=sum+stk.top();
        stk.pop();
    }
    
    cout<<sum;
    
    return 0;
}