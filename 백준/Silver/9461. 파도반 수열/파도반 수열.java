import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] dp = new long[101];
		int t,n;

		void init() throws Exception{
			Arrays.fill(dp, 0);
			t = Integer.parseInt(br.readLine());
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			for (int i = 6; i < 101; i++) {
				dp[i] = dp[i - 5] + dp[i - 1];
			}
		}

		void solve() throws Exception{
			init();
			for (int i = 0; i < t; i++) {
				n = Integer.parseInt(br.readLine());
				bw.write(dp[n] + "\n");
				bw.flush();
			}
		}
	}
}

