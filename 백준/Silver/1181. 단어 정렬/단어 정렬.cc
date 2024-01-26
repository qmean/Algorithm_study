//
// Created by 김규민 on 2024/01/26.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main()
{
    priority_queue<pair<int,string>,vector<pair<int,string>>,greater<pair<int,string>>> pq;
    int n; cin >> n;
    while (n--){
        string s; cin >> s;
        pq.push({s.size(),s});
    }
    string before;
    before = "";
    while (!pq.empty()) {
        if (before != pq.top().second) {
            cout << pq.top().second << endl;
            before = pq.top().second;
        }
        pq.pop();
    }
}