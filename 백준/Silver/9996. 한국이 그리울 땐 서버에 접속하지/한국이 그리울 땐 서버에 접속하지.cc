#include "bits/stdc++.h"

using namespace std;

int main()
{
    int t; cin >> t;
    string pattern; cin >> pattern;
    string s;
    bool flag;
    while (t--) {
        cin >> s;
        flag = true;
        for (int i = 0; i < pattern.size(); ++i) {
            if (pattern[i] == '*')
                break;
            else if (pattern[i] != s[i])
                flag = false;
        }
        for (int i = 1; i < pattern.size(); ++i) {
            if (pattern[pattern.size() - i] == '*')
                break;
            else if (pattern[pattern.size() - i] != s[s.size() - i])
                flag = false;
        }
        if (flag == true && s.size() < pattern.size() - 1)
            flag = false;
        if (flag) {
            cout << "DA\n";
        } else {
            cout << "NE\n";
        }
    }
}