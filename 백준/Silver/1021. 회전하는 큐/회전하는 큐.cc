//
// Created by 김규민 on 3/6/24.
//
#include <deque>
#include <queue>
#include <iostream>

using namespace std;

int n,m;
int cnt = 0;
deque<int> dq;
queue<int> q;

int rotate_left(deque<int> dq, int findnum) {
    int ret = 0;
    while (dq.front() != findnum) {
        int tmp = dq.front();
        dq.pop_front();
        dq.push_back(tmp);
        ret++;
    }
    return ret;
}

int rotate_right(deque<int> dq, int findnum) {
    int ret = 0;
    while (dq.front() != findnum) {
        int tmp = dq.back();
        dq.pop_back();
        dq.push_front(tmp);
        ret++;
    }
    return ret;
}

void init() {
    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        dq.push_back(i);
    }
    for (int i = 0; i < m; ++i) {
        int a; cin >> a;
        q.push(a);
    }
}

void solve() {
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        int left = rotate_left(dq, cur);
        int right = rotate_right(dq, cur);
        if (left < right) {
            for (int i = 0; i < left; ++i) {
                int tmp = dq.front();
                dq.pop_front();
                dq.push_back(tmp);
            }
            dq.pop_front();
            cnt += left;
        } else {
            for (int i = 0; i < right; ++i) {
                int tmp = dq.back();
                dq.pop_back();
                dq.push_front(tmp);
            }
            dq.pop_front();
            cnt += right;
        }
    }
    cout << cnt << endl;
}

int main() {
    init();
    solve();
}

