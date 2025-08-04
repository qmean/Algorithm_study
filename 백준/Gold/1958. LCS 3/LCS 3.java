import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] s1;
		char[] s2;
		char[] s3;
		int l1;
		int l2;
		int l3;

		void init() throws Exception{
			s1 = br.readLine().toCharArray();
			s2 = br.readLine().toCharArray();
			s3 = br.readLine().toCharArray();

			l1 = s1.length;
			l2 = s2.length;
			l3 = s3.length;
		}

		void solve() throws Exception{
			init();
			int[][][] dp = new int[l1+1][l2+1][l3+1];

			for(int i = 1; i <= l1; i++) {
				for(int j = 1; j <= l2; j++) {
					for(int k = 1; k <= l3; k++) {
						if (s1[i-1] == s2[j-1] && s2[j-1] == s3[k-1]) {
							dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
						} else {
							dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i][j-1][k]);
							dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k-1]);
						}
					}
				}
			}
			System.out.println(dp[l1][l2][l3]);
		}
	}
}
