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
    int n; cin >> n;
    long long ans = 0;
    string s; cin >> s;
    for (int i = 0; i < s.size(); ++i) {
        ans += s[i] - '0';
    }
    cout << ans << endl;
}