import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		Solution solution = new Solution();
		solution.init();
		solution.solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k, n;
		List<List<Integer>> graph = new ArrayList<>();
		boolean[] virus;
		int cnt = 0;

		void init() throws Exception {
			k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k + 1; i++) {
				graph.add(new ArrayList<>());
			}
			virus = new boolean[k + 1];
			Arrays.fill(virus, false);
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
				graph.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
			}
		}

		void solve() throws Exception {
			dfs(1);
			bw.write(String.valueOf(this.cnt - 1));
			bw.flush();
		}

		void dfs(int idx) {
			virus[idx] = true;
			this.cnt = this.cnt + 1;
			List<Integer> list = graph.get(idx);
			for (int i : list) {
				if (!virus[i])
					dfs(i);
			}
		}
	}
}
