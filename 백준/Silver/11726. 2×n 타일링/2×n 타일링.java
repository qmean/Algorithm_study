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
		int[] dp;

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
			dp = new int[n+1];
			Arrays.fill(dp, 0);
			dp[1] = 1;
			if (n != 1)
				dp[2] = 2;
			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 1] % 10007 + dp[i - 2] % 10007) % 10007;
			}
		}

		void solve() throws Exception{
			init();
			bw.write(String.valueOf(dp[n]));
			bw.flush();
		}
	}
}
