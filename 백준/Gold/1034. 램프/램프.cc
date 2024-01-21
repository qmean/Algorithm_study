#include <iostream>
#include <cstring>
#include <string>

using namespace std;

int n,m,k;
string s[51];

void init()
{
	cin >> n >> m;
	for(int i = 0; i < n; i++)
	{
		cin >> s[i];
	}
	cin >> k;
}

void solve()
{
	int max = 0;
	for (int i = 0; i < n; i++)
	{
		int cnt = 0;
		int same = 0;
		for (int j = 0; j < m; j++)
		{
			if (s[i][j] == '0')
			{
				cnt++;
			}
		}
		if (cnt <= k && k%2 == cnt % 2)
		{
			for (int j = i; j < n; j++)
			{
				if (s[j] == s[i])
					same++;
				if (same > max)
					max = same;
			}
			
		}
	}
	cout << max << endl;
}

int main()
{	
	init();
	solve();
}
