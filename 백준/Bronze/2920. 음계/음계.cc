//
// Created by 김규민 on 2024/01/24.
//
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int t;
    vector<int>v;
    for (int i = 0; i < 8; ++i) {
        cin >> t;
        v.push_back(t);
    }
    int init = v.front();
    bool asc = false;
    if (init == 1) {
        asc = true;
    }
    for (int i = 1; i < 8; ++i) {
        if (v[i] == init + 1 && asc) {
            init = v[i];
        }
        else if (v[i] == init - 1 && !asc) {
            init = v[i];
        } else {
            cout << "mixed\n";
            return 0;
        }
    }
    if (asc) {
        cout << "ascending\n";
    } else {
        cout << "descending\n";
    }
}