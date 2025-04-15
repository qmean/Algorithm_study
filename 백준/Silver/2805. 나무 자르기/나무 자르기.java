import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;
		List<Integer> trees = new ArrayList<>();

		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);

			s = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				trees.add(Integer.parseInt(s[i]));
			}
		}

		void solve() throws Exception{
			init();
			long start = 0;
			long end = trees.stream().max(Integer::compare).get();

			while (true) {
				long cur = (start + end) / 2;
				long sum = find(cur);
				if (sum >= m) {
					if (find(cur + 1) < m) {
						bw.write(cur + "\n");
						break;
					} else {
						start = cur;
					}
				} else {
					end = cur;
				}
			}
			bw.flush();
		}

		long find(long h) {
			long sum = 0;
			for (int tree : trees) {
				if (tree > h) {
					sum += tree - h;
				}
			}
			return sum;
		}
	}
}
