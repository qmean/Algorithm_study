#include <iostream>

using namespace std;

int main()
{
	int arr[50][2];
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		arr[i][0] = a;
		arr[i][1] = b;
	}
	for (int i = 0; i < n; i++) {
		int c = 1;
		for (int m=0; m < n; m++) {
			if (m != i) {
				if (arr[i][0] < arr[m][0] && arr[i][1] < arr[m][1])
					c = c + 1;
			}
			
		}
		cout << c<< ' ';
	}

	return 0;
}