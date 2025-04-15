//
// Created by 김규민 on 2024/01/24.
//
#include <iostream>
#include <string>

using namespace std;

int main() {
    int t; cin >> t;
    while (t--) {
        int r; cin >> r;
        string s; cin >> s;
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < r; ++j) {
                cout << s[i];
            }
        }
        cout << endl;
    }
}