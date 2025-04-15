import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Solution solution = new Solution();
		solution.init();
		solution.solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, k;
		Deque<Integer> coin = new ArrayDeque<>();

		void init() throws IOException {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			k = Integer.parseInt(s[1]);

			for (int i = 0; i < n; i++) {
				coin.addLast(Integer.parseInt(br.readLine()));
			}
			br.close();
		}

		void solve() throws Exception {
			boolean flag = false;
			int sum = 0;
			Integer cnt = 0;
			while (!flag) {
				Integer i = coin.removeLast();
				int currentCnt;
				if (i <= (k - sum)) {
					currentCnt = (k - sum) / i;
					cnt += currentCnt;
					sum += i * currentCnt;
					if (sum == k) {
						flag = true;
					}
				}
			}
			bw.write(String.valueOf(cnt));
			bw.flush();
		}
	}
}
