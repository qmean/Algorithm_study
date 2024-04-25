#include "bits/stdc++.h"

using namespace std;

int main() {
    int t; cin >> t;
    map<string, vector<string>> m;
    while (t--) {
        m.clear();
        int n; cin >> n;
        while (n--) {
            string s1,s2; cin >> s1 >> s2;
            m[s2].push_back(s1);
        }
        int ans = 1;
        for (auto v: m) {
            ans *= (v.second.size() + 1);
        }
        cout << ans - 1 << '\n';
    }
}