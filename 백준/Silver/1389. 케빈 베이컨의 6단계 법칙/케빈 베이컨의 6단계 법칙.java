import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<List<Integer>> map = new ArrayList<>();
		boolean[] visited;
		int[] bacon;
		int n, m;

		void init() throws Exception {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			for (int i = 0; i <= n; i++) {
				map.add(new ArrayList<>());
			}
			visited = new boolean[n + 1];
			bacon = new int[n + 1];
			for (int i = 0; i < m; i++) {
				s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				map.get(a).add(b);
				map.get(b).add(a);
			}
		}

		void solve() throws Exception {
			init();
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= n; i++) {
				Arrays.fill(visited, false);
				bfs(i);
			}
			int print = 0;
			for (int i = 1; i <= n; i++) {
				if (min > bacon[i]) {
					print = i;
					min = bacon[i];
				}
			}
			bw.write(String.valueOf(print));
			bw.flush();
		}

		void bfs(int start) {
			List<Integer> find = new ArrayList<>();
			List<Integer> tmp = new ArrayList<>();
			int sum = 0;
			int cnt = 0;
			find.add(start);
			while (!find.isEmpty()) {
				tmp.clear();
				tmp.addAll(find);
				find.clear();
				for (int i : tmp) {
					if (visited[i]) {
						continue;
					}
					find.addAll(map.get(i));
					visited[i] = true;
					sum += cnt;
				}
				cnt++;
			}
			bacon[start] = sum;
		}
	}
}
