import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;

		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
		}

		void solve() throws Exception{
			init();
			for (int i = 1; i <= n; i++) {
				cond(1, i, "");
			}
		}

		void cond(int depth, int cur, String str) {
			if (depth == m) {
				System.out.println(str + cur);
			}
			for (int i = cur+1; i <= n; i++) {
				cond(depth + 1, i, str + cur + " ");
			}
		}
	}
}
