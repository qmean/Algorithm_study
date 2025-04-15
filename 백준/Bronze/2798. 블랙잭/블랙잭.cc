//
// Created by 김규민 on 24. 11. 1.
//
#include <iostream>

using namespace std;

int n, m;
int card[100];
int maxnum;

void init()
{
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		int a; cin >> a;
		card[i] = a;
	}
}
void solve()
{
	for (int i = 0; i < n-2; ++i) {
		for (int j = i+1; j < n-1; ++j) {
			for (int k = j+1; k < n; ++k) {
				if ((card[i] + card[j] + card[k]) <= m && (card[i] + card[j] + card[k]) > maxnum)
					maxnum = card[i] + card[j] + card[k];
			}
		}
	}
	cout << maxnum << endl;
}

int main()
{
	int t;
	t = 1;
	while (t--)
	{
		init();
		solve();
	}
}