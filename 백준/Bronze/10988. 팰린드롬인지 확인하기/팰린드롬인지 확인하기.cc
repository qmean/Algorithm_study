#include "bits/stdc++.h"

using namespace std;

int main() {
    string s; cin >> s;
    string s2 = s;
    reverse(s.begin(), s.end());
    if (s.compare(s2))
        cout << 0;
    else
        cout << 1;
}