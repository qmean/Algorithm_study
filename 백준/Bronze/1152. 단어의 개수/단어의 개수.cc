//
// Created by 김규민 on 2024/01/24.
//
//
// Created by 김규민 on 2024/01/24.
//
#include <iostream>
#include <string>

using namespace std;

void init()
{

}
void solve()
{

}

int main()
{
    string s;
    getline(cin ,s);
    bool flag = false;
    int ans = 0;
    for (int i = 0; i < s.size(); ++i) {
        if (s[i] == ' ') {
            flag = false;
        } else if (flag == false){
            ans++;
            flag = true;
        } else {
            flag = true;
        }
    }
    cout << ans << endl;
}