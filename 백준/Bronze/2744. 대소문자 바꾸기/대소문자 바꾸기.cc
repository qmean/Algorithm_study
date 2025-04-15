#include <cstdio>
#include <iostream>
#include <string>
using namespace std;

int main() {

	string a;
	cin >> a;
	for (int i = 0; i < a.size(); i++) {
		if (a[i] <= 90) {
			printf("%c", a[i] + 32);
		}
		else {
			printf("%c", a[i] - 32);
		}
		
	}


	return 0;
}