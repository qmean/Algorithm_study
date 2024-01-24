//
// Created by 김규민 on 2024/01/24.
//
#include <iostream>
#include <vector>
#include <cstring>
#include <string>

using namespace std;

void init()
{

}
void solve()
{

}

int main()
{
    int arr[26];
    memset(arr, 0, sizeof(arr));
    string s; cin >> s;
    for (int i = 0; i < s.size(); ++i) {
        if (s[i] <= 'Z' && 'A' <= s[i]) {
            arr[s[i] - 'A']++;
        } else {
            arr[s[i] - 'a']++;
        }
    }
    int max = -1;
    vector<int> idx;
    for (int i = 0; i < 26; ++i) {
        if (max < arr[i]) {
            idx.clear();
            idx.push_back(i);
            max = arr[i];
        } else if (max == arr[i] && max > 0) {
            idx.push_back(i);
        }
    }
    if (idx.size() != 1) {
        cout << '?' << endl;
    } else {
        cout << (char)(idx.front() + 'A') << endl;
    }
}