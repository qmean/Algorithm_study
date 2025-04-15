#include <iostream>

using namespace std;

char result(int arr[4]);

int main()
{
    int a[4];
    char b[3];
    for(int i=0; i<3; i++){
        for(int i=0; i<4; i++){
        cin>>a[i];
        }
        b[i]=result(a);
    }
    
    for(int i=0; i<3; i++){
        cout<<b[i]<<endl;
    }
    
    
    
}

char result(int arr[4]){
    int count=0;
    for(int i=0; i<4; i++){
        if(arr[i]==0){
            count=count+1;
        }
    }
    switch(count){
        case 0:
            return 'E';
        break;
        case 1:
            return 'A';
        break;
        case 2:
            return 'B';
        break;
        case 3:
            return 'C';
        break;
        case 4:
            return 'D';
        break;
    }
    return NULL;
}
