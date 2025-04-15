import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		Solution solution = new Solution();
		solution.init();
		solution.solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int[] arr = new int[1000001];

		void init() throws Exception {
			n = Integer.parseInt(br.readLine());
			Arrays.fill(arr, -1);
		}

		void solve() throws Exception {
			int cnt = dp(n);
			bw.write(String.valueOf(cnt));
			bw.flush();
		}

		int dp(int n) {
			int a = Integer.MAX_VALUE;
			if (n == 1) {
				arr[1] = 0;
				return 0;
			} else if (arr[n] != -1) {
				return arr[n];
			}
			if (n % 3 == 0) {
				a = Math.min(a, dp(n / 3) + 1);
			}
			if (n % 2 == 0) {
				a = Math.min(a, dp(n / 2) + 1);
			}
			a = Math.min(a, dp(n - 1) + 1);
			arr[n] = a;
			return a;
		}
	}
}
