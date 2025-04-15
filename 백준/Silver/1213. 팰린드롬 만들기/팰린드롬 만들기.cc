#include "bits/stdc++.h"

using namespace std;

int c[26];

int main() {
    string s; cin >> s;
    for (auto a: s) {
        c[a-'A']++;
    }
    int cnt = 0;
    for (auto a: c) {
        if (a % 2 == 1) {
            cnt++;
        }
    }
    string ans;
    char mid = 0;
    if (cnt > 1) {
        cout << "I'm Sorry Hansoo\n";
        return (0);
    } else {
        for (int i = 0; i < 26; ++i) {
            if (c[i] % 2 == 1)
            {
                mid = i + 'A';
                c[i]--;
            }
            if (c[i] > 0) {
                for (int j = 0; j < c[i]/2; ++j) ans+= (i + 'A');
            }
        }
    }
    string tmp = ans;
    reverse(ans.begin(), ans.end());
    if (mid != 0) {
        tmp += mid;
    }
    tmp += ans;
    cout << tmp << endl;
}