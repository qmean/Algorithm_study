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
		int[][] map;
		int[][][] dp;
		int n, m;
		final int LEFT = 0, DOWN = 1, RIGHT = 2;
		void init() throws Exception{
			String[]s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			map = new int[n][m];
			dp = new int[n][m][3];

			for (int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
		}

		void solve() throws Exception{
			init();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < 3; k++) {
						dp[i][j][k] = (int)10e5;
					}
				}
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < 3; j++) {
					dp[0][i][j] = map[0][i];
				}
			}
			for(int i = 1; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (j < m-1)
						dp[i][j][LEFT] = Math.min(dp[i-1][j+1][RIGHT], dp[i-1][j+1][DOWN]) + map[i][j];

					dp[i][j][DOWN] = Math.min(dp[i-1][j][RIGHT], dp[i-1][j][LEFT]) + map[i][j];

					if (j > 0)
						dp[i][j][RIGHT] = Math.min(dp[i-1][j-1][DOWN], dp[i-1][j-1][LEFT]) + map[i][j];
				}
			}

			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < 3; j++) {
					ans = Math.min(ans, dp[n-1][i][j]);
				}
			}

			System.out.println(ans);
		}
	}
}
