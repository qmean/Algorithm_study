//
// Created by 김규민 on 24. 11. 1.
//
#include <iostream>
#include <string>

using namespace std;

int main() {
	string a,b,c;

	cin >> a >> b >> c;

	int inta = stoi(a);
	int intb = stoi(b);
	int intc = stoi(c);

	cout << inta + intb - intc << endl;

	a.append(b);
	int ab = stoi(a);
	cout << ab - stoi(c) << endl;
}