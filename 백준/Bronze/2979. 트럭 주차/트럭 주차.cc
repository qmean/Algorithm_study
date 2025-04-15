#include "bits/stdc++.h"

using namespace std;

int arr[100];

int main() {
    int a,b,c;
    cin >> a >> b >> c;
    int t, l;
    for (int i = 0; i < 3; ++i) {
        cin >> t >> l;
        for (int j = t; j < l; ++j) {
            arr[j]++;
        }
    }
    int ans = 0;
    for (int i = 0; i < 100; ++i) {
        if (arr[i] == 1)
        {
            ans += a;
        }
        else if (arr[i] == 2) {
            ans += b * 2;
        }
        else if (arr[i] == 3) {
            ans += c * 3;
        }
    }
    cout << ans << endl;
}