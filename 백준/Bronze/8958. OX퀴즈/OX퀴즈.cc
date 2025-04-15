//
// Created by 김규민 on 2024/01/24.
//
#include <iostream>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

int main()
{
    string s;
    int t; cin >> t;
    while (t--) {
        cin >> s;
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == 'O') {
                cnt++;
                ans += cnt;
            } else {
                cnt = 0;
            }
        }
        cout << ans << endl;
    }
}