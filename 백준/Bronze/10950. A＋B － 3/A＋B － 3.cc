#include <cstdio>

int main() {
	int a,n,b;
	scanf("%d", &n);
	
	for (int i = 1; i <= n; i++) {
		scanf("%d%d", &a, &b);
		printf("%d\n", a + b);

	}
	
	return 0;
}