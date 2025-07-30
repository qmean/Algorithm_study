import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] s1arr;
		char[] s2arr;

		void init() throws Exception{
			String s1 = br.readLine();
			String s2 = br.readLine();

			s1arr = s1.toCharArray();
			s2arr = s2.toCharArray();
		}

		void solve() throws Exception{
			init();

			int[][] dp = new int[s1arr.length+1][s2arr.length+1];
			for (int i = 1; i <= s1arr.length; i++) {
				for (int j = 1; j <= s2arr.length; j++) {
					if (s1arr[i - 1] == s2arr[j - 1]) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}
			System.out.println(dp[s1arr.length][s2arr.length]);
		}
	}
}
