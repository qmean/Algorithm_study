//
// Created by 김규민 on 24. 11. 1.
//
#include <iostream>

using namespace std;

int main() {
	long long n; cin >> n;

	long long find = 0;
	int idx = 0;
	while (idx < n){
		find = idx;
		int a = idx;
		while (a != 0){
			find =find + a%10;
			a= a/10;
		}
		if (find == n)
			break;
		idx++;
	}
	if (find == n)
		cout << idx << endl;
	else
		cout << 0 << endl;
}