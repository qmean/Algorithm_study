//
// Created by 김규민 on 2024/01/24.
//
#include <iostream>
#include <cstring>
#include <vector>

using namespace std;

int main()
{
    int t;
    int cnt = 0;
    bool num[42];
    memset(num, false, sizeof(num));
    for (int i = 0; i < 10; ++i) {
        cin >> t;
        if (num[t%42] == true) {
            continue;
        } else {
            cnt++;
            num[t%42] = true;
        }
    }
    cout << cnt << endl;
}