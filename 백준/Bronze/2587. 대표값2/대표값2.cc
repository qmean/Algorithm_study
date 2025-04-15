#include <iostream>
#include <algorithm>

using namespace std;



int main()
{
    int a[5];
    int sum=0;
    int ave;
    for(int i=0; i<5; i++){
        cin>>a[i];
        sum=sum+a[i];
    }
    
    ave=(sum/5);
    
    sort(a, a+5);
    
    cout<<ave<<endl<<a[2];
    
    
    return 0;
}

