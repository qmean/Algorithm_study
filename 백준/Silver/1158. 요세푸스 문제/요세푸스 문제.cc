#include <iostream>

using namespace std;

int main()
{
    int n,k;
    cin>>n>>k;
    
    int nxt[n+1];
    int pre[n+1];
    int ans[n];
    
    for(int i=0; i<n+1; i++){
        pre[i]=i-1;
        nxt[i]=i+1;
    }
    pre[0]=0;
    pre[1]=n;
    nxt[n]=1;
    
    int now=0;
    
    for(int i=0; i<n; i++){
        for(int j=0; j<k; j++){
            now=nxt[now];
        }
        ans[i]=now;
        nxt[pre[now]]=nxt[now];
        pre[nxt[now]]=pre[now];
    }
    
    cout<<'<';
    
    for(int i=0; i<n; i++){
        if(i!=n-1){
            cout<<ans[i]<<", ";
        }
        else{
            cout<<ans[i]<<'>';
        }
    }
    

    return 0;
}