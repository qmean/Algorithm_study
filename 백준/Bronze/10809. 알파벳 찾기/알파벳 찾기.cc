//
// Created by 김규민 on 2024/01/24.
//
#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int main()
{
    string s; cin >> s;
    int cnt = 0;
    int alpha[26];
    memset(alpha, -1, sizeof(alpha));
    for (auto c: s) {
        if (alpha[c - 'a'] == -1) {
            alpha[c - 'a'] = cnt;
        }
        cnt++;
    }
    for (int i = 0; i < 26; i++) {
        cout << alpha[i];
        if (i != 25) {
            cout << ' ';
        }
    }
    cout << '\n';
}