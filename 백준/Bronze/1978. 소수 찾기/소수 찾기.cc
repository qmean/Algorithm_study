#include <iostream>

using namespace std;

int a;
int cnt;

void init()
{
	cin >> a;
}
void solve()
{
	if (a == 1)
		return ;
	int b = 0;
	for (int i = 1; i <= a; ++i) {
		if (a%i == 0)
			b++;
	}
	if (b == 2)
	{
		cnt++;
	}
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
	cout << cnt << endl;
}