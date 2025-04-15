//
// Created by 김규민 on 2024/01/26.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main()
{
    while (true) {
        string s; cin >> s;
        if (s == "0")
            break;
        bool ok = true;
        for (int i = 0; i < s.size()/2; ++i) {
            if (s[i] != s[s.size() - i - 1])
                ok = false;
        }
        if (ok) {
            cout << "yes" << endl;
        } else {
            cout << "no" << endl;
        }
    }
}