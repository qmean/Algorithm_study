#include <iostream>
#include <queue>
#include <string>

using namespace std;

int main(){
    std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);
    queue<int> qu;
    int n;
    cin>>n;
    
    for(int i=0; i<n; i++){
        qu.push(i+1);
    }
    
    if(qu.size()!=1){
        qu.pop();
    }
    
    while(qu.size()!=1){
        qu.push(qu.front());
        qu.pop();
        qu.pop();
    }
    
    cout<<qu.front();
    
    
    
    return 0;
}