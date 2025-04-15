import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n,t;
		int cnt = 0;

		void init() throws Exception{
			t = Integer.parseInt(br.readLine());
		}

		void solve() throws Exception{
			init();
			for (int i = 0; i < t; i++) {
				n = Integer.parseInt(br.readLine());
				backtracking(0, 1);
				backtracking(0, 2);
				backtracking(0, 3);
				bw.write(cnt + "\n");
				bw.flush();
				cnt=0;
			}
		}

		void backtracking(int prevsum, int current) {
			if ((prevsum + current) == n) {
				cnt++;
				return ;
			}
			if ((prevsum + current) > n) {
				return ;
			}
			backtracking(prevsum + current, 1);
			backtracking(prevsum + current, 2);
			backtracking(prevsum + current, 3);
		}
	}
}

