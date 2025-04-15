#include <iostream>

using namespace std;

int main() {

	int N;
	cin >> N;
	int r;
	int e;
	int c;

	for (int a = 1; a <= N; a++) {
		cin >> r >> e >> c;
		if (r > (e - c)) {
			cout << "do not advertise\n";
		}
		else if (r < (e - c)) {
			cout << "advertise\n";
		}
		else {
			cout << "does not matter\n";
		}
	}


	return 0;
}