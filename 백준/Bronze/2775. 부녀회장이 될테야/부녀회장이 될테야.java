import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Solve solve = new Solve();
		solve.init();
		solve.solve();
	}
}

class Solve {
	int[][] apt = new int[15][15];
	int[][] sum = new int[15][15];
	int t;
	int k, n;
	Scanner sc = new Scanner(System.in);

	public Solve() {
		for (int i = 1; i <= 14; i++) {
			apt[0][i] = i;
			sum[0][i] = sum[0][i-1] + apt[0][i];
		}
		for (int i = 1; i <= 14; i++) {
			apt[i] = Arrays.copyOf(sum[i-1], 15);
			for (int j = 1; j <= 14; j++) {
				sum[i][j] = sum[i][j-1] + apt[i][j];
			}
		}
	}

	public void init() {
		t = sc.nextInt();
	}

	public void solve() {
		for (int i = 0; i < t; i++) {
			k = sc.nextInt();
			n = sc.nextInt();
			System.out.println(apt[k][n]);
		}
	}
}
