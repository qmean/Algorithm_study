#include "bits/stdc++.h"

using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m; cin >> n >> m;
    map<string, int> m1;
    map<int, string> m2;
    for (int i = 1; i <= n; ++i) {
        string s; cin >> s;
        m1.insert(make_pair(s, i));
        m2.insert(make_pair(i, s));
    }
    while (m--) {
        string s; cin >> s;
        if (atoi(s.c_str()) == 0) {
            cout << m1[s] << '\n';
        } else {
            cout << m2[stoi(s)] << '\n';
        }
    }
}