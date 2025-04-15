#include <iostream>
#include <algorithm>

using namespace std;


int main()
{
    int num1;//통화개수
    int a;//계산용
    int chargeY=0;//영식 요금 배수
    int chargeM=0;//민식 요금 배수
    
    cin>>num1;
    
    int tel[num1];
    
    for(int i=0; i<num1; i++){
        cin>>tel[i];
    }
    
    for(int i=0; i<num1; i++){
        a=tel[i];
        chargeY=chargeY+(a/30)+1;
        chargeM=chargeM+(a/60)+1;
    }
    
    if(chargeY*10>chargeM*15){
        cout<<"M "<<chargeM*15<<endl;
    }
    else if(chargeY*10<chargeM*15){
        cout<<"Y "<<chargeY*10<<endl;
    }
    else{
        cout<<"Y M "<<chargeY*10<<endl;
    }
    
    return 0;
}