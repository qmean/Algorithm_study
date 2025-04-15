#include <cstdio>

int main() {
	int a, b;
	int T,H;
	scanf("%d", &T);
	H = T;
	while (T--)
	{
		scanf("%d%d", &a, &b);
		if (T == 0)
		{
			printf("Case #%d: %d", H - T, a + b);
			break;
		}
		printf("Case #%d: %d\n",H-T ,a + b);
	}



	return 0;
}