#include <iostream>

using namespace std;

int main()
{
	int train=0;//기차 안의 사람수
	int arr[4];//각 역의 사람수
	int c=0;
	for (int i = 0; i < 4; i++) {
		int a, b;
		cin >> a >> b;
		train = train - a+b;
		arr[i] = train;
	}
	for (int i = 0; i < 4; i++) {
		if (i == 0) {
			c = arr[i];
		}
		else {
			if (arr[i - 1] < arr[i]) {
				c = arr[i];
			}
		}
	}
	cout << c;
	return 0;
}