import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[][] map;
		int n;

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
			map = new long[n][];
			for (int i = 1; i <= n; i++) {
				map[i-1] = new long[i];
			}
			String[] s;
			for (int i = 0; i <n ; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j <=i ; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
		}

		void solve() throws Exception{
			init();
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i+1; j++) {
					if (j == 0) {
						map[i][j] = map[i-1][j] + map[i][j];
					} else if (j > 0 && j < i) {
						long max = Math.max(map[i-1][j], map[i-1][j-1]);
						map[i][j] = map[i][j] + max;
					} else {
						map[i][j] = map[i-1][j-1] + map[i][j];
					}
				}
			}
			long max = 0;
			for (int i = 0; i <n ; i++) {
				max = Math.max(max, map[n - 1][i]);
			}
			System.out.println(max);
		}
	}
}
