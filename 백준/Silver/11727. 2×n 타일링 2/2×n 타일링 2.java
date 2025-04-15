import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] dp = new long[1001];
		int n;

		void init() throws Exception{
			Arrays.fill(dp, 1001);
			n = Integer.parseInt(br.readLine());
			dp[1] = 1;
			dp[2] = 3;
			for (int i = 3; i <=n ; i++) {
				dp[i] = (dp[i-1] % 10007 + (dp[i-2] * 2) % 10007) % 10007;
			}
		}

		void solve() throws Exception{
			init();
			bw.write(String.valueOf(dp[n]));
			bw.flush();
		}
	}
}
