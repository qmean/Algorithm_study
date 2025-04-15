//
// Created by 김규민 on 24. 11. 1.
//
#include <iostream>

using namespace std;

int main(){
	long long n; cin >> n;
	long long a = 0;

	if (n == 1)
	{
		cout << 1 << endl;
		return 0;
	}
	long long cnt = 1;
	while (1) {
		long long room = 6 * a;
		if (cnt < n && n <= cnt + room)
		{
			cout << a + 1<< endl;
			break;
		}
		cnt += room;
		a++;
	}
	return 0;
}