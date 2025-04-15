#include "bits/stdc++.h"

using namespace std;

int main()
{
    string s;
    getline(cin, s);
    for (int i = 0; i < s.size(); ++i) {
        if ('a' <= s[i] && s[i] <= 'z') {
            if (s[i] + 13 > 'z') s[i] = s[i] - 13;
            else s[i] = s[i] + 13;
        } else if ('A' <= s[i] && s[i] <= 'Z') {
            if (s[i] + 13 > 'Z') s[i] = s[i] - 13;
            else s[i] = s[i] + 13;
        }
    }
     cout << s;
}