#include <cstdio>

int main() {
	int a, b;
	char c;
	int T;
	scanf("%d", &T);
	while (T--)
	{
		scanf("%d%c%d", &a, &c, &b);
		printf("%d\n", a + b);
	}



	return 0;
}