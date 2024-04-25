#include "bits/stdc++.h"

using namespace std;


int main() {
    int n,k; cin>>n>>k;
    vector<long long> v;
    v.push_back(0);
    for (int i = 0; i < n; i++) {
        int a; cin >> a;
        v.push_back(v.back() + a);
    }
    long long ans = LONG_LONG_MIN;
    for (int i = 0; i <= n - k; i++) {
        if (ans < v[i+k] - v[i]) {
            ans = v[i+k] - v[i];
        }
    }
    cout << ans << endl;
}
