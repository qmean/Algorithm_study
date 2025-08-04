import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1;
		String s2;
		void init() throws Exception{
			s1 = br.readLine();
			s2 = br.readLine();
		}

		void solve() throws Exception{
			init();
			int s1l = s1.length();
			int s2l = s2.length();
			int[][] dp = new int[s1l+1][s2l+1];
			
			for(int i = 1; i <= s1l; i++) {
				for(int j = 1; j <= s2l; j++) {
					if (s1.charAt(i-1) == s2.charAt(j-1)) {
						dp[i][j] = dp[i-1][j-1] + 1;
					}
				}
			}

			int max = Integer.MIN_VALUE;
			for (int i = 0; i <= s1l; i++) {
				for (int j = 0; j <= s2l; j++) {
					max = Math.max(max, dp[i][j]);
					// System.out.print(dp[i][j] + " ");
				}
				// System.out.println();
			}
			System.out.println(max);
		}
	}
}
