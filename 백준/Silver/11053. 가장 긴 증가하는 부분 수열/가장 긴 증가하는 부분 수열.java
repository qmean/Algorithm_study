import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int[] arr;
		int[] dp;
		int max = 0;

		void init() throws Exception {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			dp = new int[n];
			String[] s = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
		}

		void solve() throws Exception{
			init();
			for (int i = 0; i < n; i++) {
				max = Math.max(max, dp(i));
			}
			System.out.println(max);
		}

		int dp(int cur) {
			if (dp[cur] != 0) {
				return dp[cur];
			}
			boolean find = false;
			for (int i = 0; i <cur ; i++) {
				if (arr[i] < arr[cur]) {
					find = true;
					dp[cur] = Math.max(dp[i] + 1, dp[cur]);
				}
			}
			if (!find) {
				dp[cur] = 1;
			}
			return dp[cur];
		}
	}
}
