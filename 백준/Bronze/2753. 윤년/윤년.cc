#include <iostream>

using namespace std;

int main()
{
   int g;
   cin>>g;
   
  if((g%4)==0){
      if((g%100)!=0||(g%400)==0){
          cout<<"1";
      }
      else{
          cout<<"0";
      }
  }
  else{
      cout<<"0";
  }
  
  return 0;
}