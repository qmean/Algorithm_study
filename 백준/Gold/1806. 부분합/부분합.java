import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, s;
		long arr[];
		int min = Integer.MAX_VALUE;

		void init() throws Exception {
			String[] s1 = br.readLine().split(" ");
			n = Integer.parseInt(s1[0]);
			s = Integer.parseInt(s1[1]);

			arr = new long[n + 1];
			s1 = br.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				int num = Integer.parseInt(s1[i - 1]);
				arr[i] = num + arr[i - 1];
			}
		}

		void solve() throws Exception {
			init();
			if (arr[n] < s) {
				bw.write("0");
				bw.flush();
				return;
			}

			int p1 = 0;
			int p2 = 0;
			while (p1 <= n && p2 <= n) {
				if (arr[p2] - arr[p1] >= s) {
					min = Math.min(p2 - p1, min);
					p1++;
					continue;
				}
				p2++;
			}

			bw.write(String.valueOf(min));
			bw.flush();
		}
	}
}
