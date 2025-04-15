//
// Created by 김규민 on 24. 11. 1.
//
#include <iostream>
#include <cmath>

using namespace std;

int main()
{
	int a, b, c;
	while (1)
	{
		cin >> a >> b >> c;
		if (a+b+c == 0)
			break;
		a = pow(a, 2);
		b = pow(b, 2);
		c = pow(c, 2);
		if (a + b == c | b + c == a | a + c == b) {
			cout << "right\n";
			continue;
		}
		cout << "wrong\n";
	}
}