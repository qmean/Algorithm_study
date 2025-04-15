#include <iostream>
#include <cstring>

using namespace std;

int main()
{
   double a, b;
   cin>>a;
   cin>>b;
   double result;
   cout<<fixed;
   cout.precision(10);
   result = a/b;
   cout<<result;
   return 0;
}