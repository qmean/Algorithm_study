#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> v;

int main()
{
	for (size_t i = 1; i <= 20; i++)
		v.push_back(i);
	for (size_t i = 0; i < 10; i++)
	{
		int a, b; cin >> a >> b;
		reverse(&v[a-1],&v[b]);
	}
	for (int a: v)
		cout << a << ' ';
	cout << endl;
}