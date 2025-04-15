#include <cstdio>
#include <iostream>
#include <string>
using namespace std;

int main() {

	string a,b;
	int c, d;
	cin >> a >> b;
	c=(a[0]-48) + (a[1]-48) * 10 + (a[2]-48) * 100;
	d=(b[0]-48) + (b[1]-48) * 10 + (b[2]-48) * 100;
	if (c < d) {
		cout << d;
	}
	else {
		cout << c;
	}


	return 0;
}