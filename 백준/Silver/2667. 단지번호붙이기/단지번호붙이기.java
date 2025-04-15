import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		boolean[][] map;
		boolean[][] visited;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		void init() throws Exception {
			n = Integer.parseInt(br.readLine());
			map = new boolean[n + 1][n + 1];
			visited = new boolean[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				String s = br.readLine();
				for (int j = 1; j <= n; j++) {
					map[j][i] = s.charAt(j - 1) - '0' == 1;
				}
			}
		}

		void solve() throws Exception {
			init();
			List<Integer> list = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (!visited[j][i] && map[j][i]) {
						list.add(dfs(j, i));
					}
				}
			}
			list.sort(Comparator.naturalOrder());
			System.out.println(list.size());
			for (int i : list) {
				System.out.println(i);
			}
		}

		int dfs(int x, int y) {
			if (visited[x][y] || !map[x][y]) {
				return 0;
			}
			visited[x][y] = true;
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				if (x + dx[i] <= 0 || x + dx[i] > n || y + dy[i] <= 0 || y + dy[i] > n) continue;
				if (!map[x + dx[i]][y+dy[i]]) continue;
				sum += dfs(x + dx[i], y + dy[i]);
			}
			return sum+1;
		}
	}
}
