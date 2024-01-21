#include <iostream>
#include <vector>
#include <cstring>
#include <queue>

using namespace std;

int n,m,ans;
bool person[51];
bool f_party[51];
vector<vector<int>> party;
queue<int> q;

void check(int p);

void init()
{
    cin >> n >> m;
    memset(person, false, sizeof(person));
    memset(f_party, true, sizeof(f_party));
    int t; cin >> t;
    while (t--)
    {
        int a; cin >> a;
        person[a] = true;
    }
    for (int i = 0; i < m; i++)
    {
        f_party[i] = true;
        int a; cin >> a;
        vector<int> tmp;
        while (a--)
        {
            int b; cin >> b;
            tmp.push_back(b);
        }
        party.push_back(tmp);
    }
}

void solve()
{
    for (int i = 1; i <= n; i++) {
        if (person[i] == true) {
            check(i);
        }
        while (!q.empty())
        {
            int a = q.front();
            check(a);
            q.pop();
        }
    }
    ans = 0;
    for (int i = 0; i < m; i++) {
        if (!f_party[i])
            continue;
        ans++;
    }
    cout << ans << endl;
}

void check(int p)
{
    for (int i = 0; i < m; i++) {
        bool flag = false;
        // 해당 파티에 p가 있는지 확인
        for (int j: party[i]) {
            if (p == j && f_party[i] == true) {
                flag = true;
            }
        }
        if (!flag)
            continue;
        // 파티에 p가 있으면 그 파티에서 진실을 모르는 사람들이 모두 진실을 알게됨
        for (int j: party[i]) {
            if (p != j && person[j] == false) {
                person[j] = true;
                q.push(j);
            }
        }
        // 파티에서 과장을 할 수 없게됨
        f_party[i] = false;
    }
}

int main() {
    init();
    solve();
}