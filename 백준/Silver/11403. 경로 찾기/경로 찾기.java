import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int[][] arr;
		int[][] ans;

		void init() throws Exception {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1][n+1];
			ans = new int[n+1][n+1];

			for (int i = 1; i <= n; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Integer.parseInt(s[j - 1]);
				}
			}
		}

		// 2->3 2->7
		void solve() throws Exception{
			init();
			for (int i = 1; i <= n; i++) {
				find(i, i);
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <=n ; j++) {
					bw.write(String.valueOf(ans[i][j]));
					if (j != n) {
						bw.write(" ");
					}
				}
				bw.write("\n");
				bw.flush();
			}
			bw.close();
		}

		void find(int start, int cur) {
			for (int k = 1; k <= n; k++) {
				// if (start == k) {
				// 	ans[start][k] = 1;
				// } else
				if (arr[cur][k] == 1 && ans[start][k] == 0) {
					ans[start][k] = 1;
					find(start, k);
				}
			}
		}
	}
}
