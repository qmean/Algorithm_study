#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int m;
string n;
int mod = 1234567891;
int r = 31;

void init()
{
	cin >> m;
	cin >> n;
}

// 모듈러 거듭제곱 함수
long long modular_pow(long long base, int exp, int mod) {
	long long result = 1;
	while (exp > 0) {
		if (exp % 2 == 1) { // exp가 홀수인 경우
			result = (result * base) % mod;
		}
		base = (base * base) % mod;
		exp /= 2;
	}
	return result;
}

void solve()
{
	unsigned long long hash_value = 0;
	for (int i = 0; i < n.size(); ++i) {
		int a = (n[i] - 'a' + 1);
		// 모듈러 거듭제곱을 사용하여 r^i % mod 계산
		long long rsum = modular_pow(r, i, mod);
		hash_value = (hash_value + a * rsum % mod) % mod;
	}
	cout << hash_value << endl;
}

int main()
{
	init();
	solve();
}
