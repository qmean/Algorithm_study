//
// Created by 김규민 on 2024/01/26.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

long long output = 0;

int main()
{
    int n; cin >> n;
    float max = 0;
    vector<float> v;
    while (n--) {
        float t; cin >> t;
        if (max < t) {
            max = t;
        }
        v.push_back(t);
    }
    float sum = 0;
    for (double e: v) {
        sum += e;
    }
    cout << (sum / v.size()) * (100) / max << endl;
}
