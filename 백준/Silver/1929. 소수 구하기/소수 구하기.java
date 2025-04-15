import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		new Boj1929Solution().solve();
	}

	static class Boj1929Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;

		void solve() throws IOException {
			String[] split = br.readLine().split(" ");
			n = Integer.parseInt(split[0]);
			m = Integer.parseInt(split[1]);

			for (int i = n; i <= m; i++) {
				if (isPrime(i)) {
					bw.write(String.valueOf(i) + "\n");
				}
			}
			bw.flush();
		}

		boolean isPrime(int num) {
			if (num == 2 || num == 3) {
				return true;
			}
			if (num == 1) {
				return false;
			} else if (num % 2 == 0 || num % 3 == 0) {
				return false;
			}
			double sqrt = Math.sqrt(num);
			for (int i = 6; i <= sqrt + 1; i+=6) {
				if (num % (i - 1) == 0 && (i - 1) < num) {
					return false;
				} else if (num % (i + 1) == 0 && (i + 1) < num) {
					return false;
				}
			}
			return true;
		}
	}
}
