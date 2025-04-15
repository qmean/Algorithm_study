import java.util.Scanner;

class Problem {
	int n;
	int m;
	int[][] map;
	int print = -1;

	public void init() {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = scanner.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
	}

	public void solve() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int nk = -n; nk < n; nk++) {
					for (int mk = -m; mk < m; mk++) {
						if (nk == 0 && mk == 0) {
							continue;
						}
						int x = i;
						int y = j;
						int find = 0;
						while (x >= 0 && x < n && y >= 0 && y < m) {
							find = find * 10 + map[x][y];
							int sqrt;
							if (find == 0) {
								sqrt = 0;
							} else {
								sqrt = (int)Math.sqrt(find);
							}
							if (sqrt * sqrt == find && find > print) {
								print = find;
							}
							x += nk;
							y += mk;
						}
					}
				}
			}
		}
		System.out.println(print);
	}
}

class Main {
	public static void main(String[] args) {
		Problem s = new Problem();
		s.init();
		s.solve();
	}
}
