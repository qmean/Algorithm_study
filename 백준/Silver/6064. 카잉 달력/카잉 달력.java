import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t;

		void init() throws Exception {
			t = Integer.parseInt(br.readLine());
		}

		void solve() throws Exception {
			init();
			for (int i = 0; i < t; i++) {
				solution();
				if (i != t-1)
					bw.write("\n");
				bw.flush();
			}
		}

		void solution() throws Exception {
			int n,m,x,y;
			String[] s = br.readLine().split(" ");
			m = Integer.parseInt(s[0]);
			n = Integer.parseInt(s[1]);
			x = Integer.parseInt(s[2]);
			y = Integer.parseInt(s[3]);

			// 최소공약수
			int min = 1;
			for (int i = Math.min(m, n); i > 0; i--) {
				if (m % i == 0 && n % i == 0) {
					min = i;
					break;
				}
			}
			// 카잉 달력 마지막 해
			int maxCnt = m * (n / min);

			char maxValue;
			if (m > n) {
				maxValue = 'M';
			} else {
				maxValue = 'N';
			}

			int idx = 0;
			int ans = -1;
			while (true) {
				if (maxValue == 'M') {
					if (m * idx + x > maxCnt)
						break;
					int tmp = (m * idx + x - y) % n;
					int multiple = (m * idx + x - y) / n;
					if (tmp == 0) {
						ans = n * multiple + y;
					}
				} else {
					if (n * idx + y > maxCnt)
						break;
					int tmp = (n * idx + y - x) % m;
					int multiple = (n * idx + y - x) / m;
					if (tmp == 0) {
						ans = m * multiple + x;
					}
				}
				idx++;
			}
			bw.write(String.valueOf(ans));
		}
	}
}
