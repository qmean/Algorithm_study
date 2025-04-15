#include <iostream>
#include <queue>
#include <string>
using namespace std;

int main()
{
	priority_queue<int> pq;
	for (int i = 0; i < 3; i++) {
		int a;
		cin >> a;
		pq.push(a);
	}
	string b;
	cin >> b;
	int c, d, e;//c=max(C) d=mid(B) e=min(A)
	c = pq.top();
	pq.pop();
	d = pq.top();
	pq.pop();
	e = pq.top();
	pq.pop();
	
	for (int i = 0; i < 3; i++) {
		if (b[i] == 65) {
			cout << e;
		}
		else if (b[i] == 66) {
			cout << d;
		}
		else {
			cout << c;
		}
		if(i!=3)cout << ' ';
	}

	return 0;
}