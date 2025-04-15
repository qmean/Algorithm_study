#include "bits/stdc++.h"

using namespace std;

int main() {
    vector<int> v;
    vector<bool> ok;
    int n,m; cin >> n >> m;

    while (n--) {
        int a; cin >> a;
        v.push_back(a);
        ok.push_back(true);
    }
    int ans = 0;
    for (int i = 0; i < v.size(); ++i) {
        for (int j = i+1; j < v.size(); ++j) {
            if (v[i] + v[j] == m && ok[i] && ok[j]) {
                ok[i] = false;
                ok[j] = false;
                ans++;
            }
        }
    }
    cout << ans << endl;
}