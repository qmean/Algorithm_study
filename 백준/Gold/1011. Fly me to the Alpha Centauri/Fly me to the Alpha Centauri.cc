#include <iostream>

using namespace std;

int x, y;
int dist;

void init()
{
    cin >> x >> y;
    dist = y - x;
}
void solve()
{
    long long sum = 1;
    long long cnt = 2;
    long long ans = 0;

    while (((sum * 2) + cnt) <= dist)
    {
        sum += cnt;
        cnt++;
        ans++;
    }

    cnt -= 1;
    sum = sum - cnt;
    sum = sum * 2 + cnt;
    ans = ans * 2 + 1;
    long long sub = dist - sum;
    while (sub)
    {
        if (cnt <= sub)
        {
            ans += sub / cnt;
            sub = sub % cnt;
        }
        cnt--;
    }
    cout << ans << endl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        init();
        solve();
    }
}