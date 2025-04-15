import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[][] map = new boolean[50][50];
		boolean[][] visited = new boolean[50][50];
		int t, k, m, n;
		int ans;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		void init() throws Exception {
			t = Integer.parseInt(br.readLine());
		}

		void solve() throws Exception {
			init();
			while (t > 0) {
				for (int i = 0; i < 50; i++) {
					Arrays.fill(map[i], false);
					Arrays.fill(visited[i], false);
				}
				ans = 0;
				String[] s = br.readLine().split(" ");
				k = Integer.parseInt(s[0]);
				m = Integer.parseInt(s[1]);
				n = Integer.parseInt(s[2]);

				for (int i = 0; i < n; i++) {
					s = br.readLine().split(" ");
					map[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = true;
				}

				for (int i = 0; i < 50; i++) {
					for (int j = 0; j < 50; j++) {
						if (!visited[i][j] && map[i][j]) {
							bfs(i, j);
							ans++;
						}
					}
				}
				bw.write(ans + "\n");
				bw.flush();
				t--;
			}
		}

		void bfs(int x, int y) {
			if (visited[x][y] || !map[x][y]) {
				return;
			}
			visited[x][y] = true;
			for (int i = 0; i < 4; i++) {
				if (x + dx[i] < 0 || x + dx[i] >= k || y + dy[i] < 0 || y + dy[i] >= m) {
					continue;
				}
				bfs(x + dx[i], y + dy[i]);
			}
		}
	}
}
