import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;
		char[][] map;
		boolean[][] visited;
		final char EMPTY = 'O';
		final char WALL = 'X';
		final char PERSON = 'P';
		int xStart, yStart;
		int count = 0;

		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);

			map = new char[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				String s1 = br.readLine();
				for (int j = 0; j <m ; j++) {
					map[i][j] = s1.charAt(j);
					if (map[i][j] == 'I') {
						xStart = i;
						yStart = j;
					}
				}
			}
		}

		void solve() throws Exception{
			init();
			dfs(xStart, yStart);

			if (count != 0)
				bw.write(count + "\n");
			else
				bw.write("TT\n");
			bw.flush();
		}

		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		void dfs(int x, int y) {
			if (visited[x][y] || map[x][y] == WALL) {
				return ;
			}
			visited[x][y] = true;
			if (map[x][y] == PERSON) {
				count++;
			}
			for (int i = 0; i <4; i++) {
				if (x + dx[i] >= n || x + dx[i] < 0 || y + dy[i] >= m || y + dy[i] < 0) {
					continue;
				}
				dfs(x + dx[i], y + dy[i]);
			}
		}
	}
}
