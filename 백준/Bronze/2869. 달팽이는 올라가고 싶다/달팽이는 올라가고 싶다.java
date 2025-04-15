import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}

	public static class Solution {
		int a, b, v;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		public void solve() throws IOException {
			init();
			int n = a - b;
			int ans;

			if ((v - a) % n != 0) {
				ans = (v - a) / n + 1;
			}
			else
				ans = (v - a) / n;

			bw.write(String.valueOf(ans + 1));
			bw.newLine();
			bw.flush();
		}

		public void init() throws IOException {
			String[] s = br.readLine().split(" ");
			a = Integer.parseInt(s[0]);
			b = Integer.parseInt(s[1]);
			v = Integer.parseInt(s[2]);
		}
	}
}
