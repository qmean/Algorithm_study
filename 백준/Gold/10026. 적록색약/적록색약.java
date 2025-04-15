import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		char[][] map1;
		char[][] map2;
		boolean[][] visited1;
		boolean[][] visited2;

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
			map1 = new char[n][n];
			map2 = new char[n][n];
			visited1 = new boolean[n][n];
			visited2 = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					map1[j][i] = s.charAt(j);
					if (s.charAt(j) == 'R') {
						map2[j][i] = 'G';
					} else {
						map2[j][i] = s.charAt(j);
					}
				}
			}
		}

		void solve() throws Exception{
			init();
			int ans1 = 0;
			int ans2 = 0;

			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (!visited1[x][y]) {
						dfs(x, y, map1[x][y], visited1, map1);
						ans1++;
					}
					if (!visited2[x][y]) {
						dfs(x, y, map2[x][y], visited2, map2);
						ans2++;
					}
				}
			}

			System.out.println(ans1 + " " + ans2);
		}

		void dfs(int x, int y, char color, boolean[][] visited, char[][] map) {
			if (visited[x][y]) {
				return ;
			}
			if (map[x][y] != color) {
				return ;
			}
			visited[x][y] = true;
			for (int i = 0; i < 4; i++) {
				if (x + dx[i] < 0 || x + dx[i] >= n || y + dy[i] < 0 || y + dy[i] >= n) {
					continue;
				}
				dfs(x + dx[i], y + dy[i], color, visited, map);
			}
		}
	}
}
