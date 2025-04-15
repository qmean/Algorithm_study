import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int[][] max;
		int[][] min;

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
			max = new int[n][3];
			min = new int[n][3];
			String[] s;
			for (int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				max[i][0] = Integer.parseInt(s[0]);
				max[i][1] = Integer.parseInt(s[1]);
				max[i][2] = Integer.parseInt(s[2]);
				min[i][0] = Integer.parseInt(s[0]);
				min[i][1] = Integer.parseInt(s[1]);
				min[i][2] = Integer.parseInt(s[2]);
			}
		}

		void solve() throws Exception{
			init();
			for (int i = 1; i <n ; i++) {
				max[i][0] += Math.max(max[i - 1][0], max[i - 1][1]);
				max[i][1] += Math.max(max[i-1][2], Math.max(max[i - 1][0], max[i - 1][1]));
				max[i][2] += Math.max(max[i - 1][1], max[i - 1][2]);

				min[i][0] += Math.min(min[i - 1][0], min[i - 1][1]);
				min[i][1] += Math.min(min[i-1][2], Math.min(min[i - 1][0], min[i - 1][1]));
				min[i][2] += Math.min(min[i - 1][1], min[i - 1][2]);
			}
			int minAns = Math.min(Math.min(min[n - 1][0], min[n - 1][1]), min[n - 1][2]);
			int maxAns = Math.max(Math.max(max[n - 1][0], max[n - 1][1]), max[n - 1][2]);

			System.out.println(maxAns + " " + minAns);
		}
	}
}
