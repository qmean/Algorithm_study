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
		int n;
		int[] arr;
		int[] arr1;
		int[] arr2;
		int[][] dp;
		int t;

		void init() throws Exception {
			n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			t = Integer.parseInt(br.readLine());
		}

		void solve() throws Exception{
			init();
			arr1 = new int[n];
			arr2 = new int[n];
			System.arraycopy(arr, 0, arr1, 0, n);
			for(int i = n-1; i >= 0; i--) {
				arr2[n - 1 - i] = arr[i];
			}
			dp = new int[n+1][n+1];
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(arr1[i-1] == arr2[j-1]) {
						dp[i][j] = dp[i-1][j-1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			for(int i = 0; i < t; i++) {
				solution();
			}
		}

		void solution() throws Exception {
			int m = Integer.parseInt(br.readLine());
			int a = m-1;
			int b = n - m;
			bw.write(String.valueOf(a + b - 2 * dp[a][b]) + "\n");
			bw.flush();
		}
	}
}
