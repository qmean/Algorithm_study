//
// Created by 김규민 on 3/6/24.
//
#include <deque>
#include <iostream>
#include <algorithm>

using namespace std;

deque<int> dq;
deque<char> cmd;
string str;
int datanum;
bool ret;
bool rev;

void init() {
    cin >> str;
    dq.clear();
    cmd.clear();
    ret = false;
    rev = false;

    for (char c: str) {
        cmd.push_back(c);
    }

    cin >> datanum;
    if (datanum == 0) {
        cin >> str;
        return;
    }

    cin >> str;
    int tmp = 0;
    for (char c: str) {
        if ('0' <= c && c <= '9') {
            tmp = tmp * 10 + c - '0';
        } else if (c == '[') {
            continue;
        }else {
            dq.push_back(tmp);
            tmp = 0;
        }
    }
}

bool R_func() {
    rev = !rev;
    return true;
}

bool D_func() {
    if (dq.empty()) {
        return false;
    }
    if (rev) {
        dq.pop_back();
    } else {
        dq.pop_front();
    }
    return true;
}
void solve() {
    while (!cmd.empty()) {
        char tmp = cmd.front();
        cmd.pop_front();
        if (tmp == 'R') {
            R_func();
        } else {
            if (!D_func()) {
                cout << "error" << endl;
                return;
            }
        }
    }
    cout << '[';
    while (!dq.empty()) {
        if (rev) {
            cout << dq.back();
            dq.pop_back();
        } else {
            cout << dq.front();
            dq.pop_front();
        }
        if (dq.size() != 0) {
            cout << ',';
        }
    }
    cout << "]\n";
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        init();
        solve();
    }
}