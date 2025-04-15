import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int[] dp = new int[50001];

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
			Arrays.fill(dp, Integer.MAX_VALUE);
			int pow = 1;
			for (int i = 1; i <= n ; i++) {
				if (Math.pow(pow, 2) == i) {
					dp[i] = 1;
					pow++;
					continue ;
				}
				int start = pow - 1;
				while (start != 0) {
					int tmp = start * start;
					if (dp[tmp] + dp[i - tmp] < dp[i]) {
						dp[i] = dp[tmp] + dp[i - tmp];
					}
					start--;
				}
			}
		}

		void solve() throws Exception{
			init();
			bw.write(String.valueOf(dp[n]));
			bw.flush();
		}
	}
}
