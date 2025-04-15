#include "bits/stdc++.h"

using namespace std;

int main() {
    int t; cin >> t;
    int ans = 0;
    while (t--) {
        string s; cin >> s;
        deque<char> dq;
        stack<char> st;
        for (char c: s) {
            dq.push_back(c);
        }
        if (dq.size()%2 != 0)
            continue;
        while (!dq.empty()) {
            char fc = dq.front();
            dq.pop_front();
            if (st.size() !=0 && st.top() == fc) {
                st.pop();
            } else {
                st.push(fc);
            }
        }
        if (st.empty())
            ans++;
    }
    cout << ans << endl;
}