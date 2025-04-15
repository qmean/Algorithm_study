#include <iostream>
#include <string>

using namespace std;

int main()
{
    int a[2][6];//a[0이 여자 a[1]이 남자
    for(int i=0; i<2; i++){
        for(int j=0; j<6; j++){
            a[i][j]=0;
        }
    }
    
    int b,c,d,e,max;
    cin>>b>>max;
    
    for(int i=0; i<b; i++){
        cin>>c>>d;
        if(c==0){
            a[0][d-1]++;
        }
        else{
            a[1][d-1]++;
        }
    }
    e=0;//방개수 초기화
    for(int i=0; i<2; i++){
        for(int j=0; j<6; j++){
            int inc;
            inc = (a[i][j]+max-1)/max;
            e = e+inc;
        }
    }
    
    cout<<e;
    
    return 0;
}