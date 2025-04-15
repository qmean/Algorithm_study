//
// Created by 김규민 on 24. 11. 1.
//
#include <iostream>
#include <vector>

using namespace std;

int main()
{
	int n; cin >> n;

	int t,p;

	vector<int> v;
	int a;
	for (int i = 0; i < 6; ++i) {
		cin >> a;
		v.push_back(a);
	}
	cin >> t >> p;
	int ans1 = 0, ans2 = 0;
	for (int i = 0; i < 6; ++i) {
		if (v[i]%t == 0)
			ans1+= v[i]/t;
		else
			ans1+= v[i]/t + 1;
	}
	cout << ans1 << endl;
	ans1 = n/p;
	ans2 = n%p;
	cout << ans1 << " " << ans2 << endl;
}