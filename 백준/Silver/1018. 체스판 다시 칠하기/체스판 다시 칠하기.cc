//
// Created by 김규민 on 2024/01/24.
//
#include <iostream>
#include <string>
#include <cstring>
#define White true
#define Black false
using namespace std;

bool map[51][51];

int count(int x, int y) {
    int cnt1 = 0;
    int cnt2 = 0;
    bool next1 = map[x][y];
    for (int i = y; i < y + 8; i++) {
        for (int j = x; j < x + 8; j++) {
            if (next1 != map[j][i]) {
                cnt1++;
            } else {
                cnt2++;
            }
            next1 = !next1;
        }
        next1 = !next1;
    }
    if (cnt1 < cnt2) {
        return cnt1;
    } else {
        return cnt2;
    }
}

int main()
{
    int n,m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            char c; cin >> c;
            if (c == 'W') {
                map[j][i] = White;
            } else {
                map[j][i] = Black;
            }
        }
    }
    int min = 2000000;
    for (int i = 1; i <= n-7; i++) {
        for (int j = 1; j <= m-7; j++) {
            if (min > count(j,i)) {
                min = count(j, i);
            }
        }
    }
    cout << min << endl;
}