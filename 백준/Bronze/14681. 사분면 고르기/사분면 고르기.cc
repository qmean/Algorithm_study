#include <iostream>

using namespace std;

int main()
{
   int x,y;
   cin>>x>>y;
   
   if(x>0){//x가 양수
       if(y>0){
            cout<<"1";
       }
       else{
           cout<<"4";
       }
   }
   else{//x가 음수
       if(y>0){
           cout<<"2";
       }
       else{
           cout<<"3";
       }
   }
  
  return 0;
}