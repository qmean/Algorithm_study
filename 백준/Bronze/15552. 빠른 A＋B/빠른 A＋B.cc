#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T,A,B;
    cin>>T;
    int a[T];
    
    
    for(int i=0; i<T; i++){
        cin>>A>>B;
        
        a[i]=A+B;
    }
    
    for(int i=0; i<T; i++){
        cout<<a[i]<<"\n";
    }
    
    return 0;
}
