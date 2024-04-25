#include "bits/stdc++.h"

using namespace std;

int c[26];

int main()
{
    int t; cin >>t;
    while (t--) {
        string s; cin >> s;
        c[s.at(0) - 'a']++;
    }
    bool flag = false;
    int cnt = 0;
    for (auto inp:c) {
        if (inp >= 5) {
            cout << (char)(cnt + 'a');
            flag = true;
        }
        cnt++;
    }
    if (!flag)
        cout << "PREDAJA";
    cout << '\n';
}