import java.io.*;
import java.util.*;

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
		int[] arr;
		long[] dp;

		void init() throws Exception {
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1]; Arrays.fill(arr, 0);
			dp = new long[n + 1]; Arrays.fill(dp, 0);
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
		}

		void solve() throws Exception {
			dp[1] = arr[1];
			bw.write(String.valueOf(dp(n)));
			bw.flush();
		}

		long dp(int idx) {
			if (idx <= 0) {
				return 0;
			}
			if (dp[idx] != 0) {
				return dp[idx];
			}
			dp[idx] = Math.max(dp(idx - 2), dp(idx - 3) + arr[idx - 1]) + arr[idx];
			return dp[idx];
		}
	}
}
