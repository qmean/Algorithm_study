import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;
		int[][] map;
		boolean[][] visited;
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};

		void init() throws Exception {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			map = new int[m + 1][n + 1];
			visited = new boolean[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				String s1 = br.readLine();
				for (int j = 1; j <= m; j++) {
					char num = s1.charAt(j-1);
					if (num == '1') {
						map[j][i] = -1;
					} else {
						map[j][i] = 0;
					}
				}
			}
		}

		void solve() throws Exception {
			init();
			Queue<Pair> q = new ArrayDeque<>();
			q.add(Pair.of(1, 1));
			map[1][1] = 1;
			while (!q.isEmpty()) {
				Pair cur = q.poll();
				int x = cur.getFirst();
				int y = cur.getSecond();
				// System.out.println("x +\",\"+y+\",\"+map[x][y] = " + x + "," + y + "," + map[x][y]);
				for (int i = 0; i < 4; i++) {
					// 이동할 수 있는 좌표일 때
					if (x + dx[i] > 0 && x + dx[i] <= m
						&& y + dy[i] > 0 && y + dy[i] <= n
						&& map[x + dx[i]][y + dy[i]] != 0 && map[x + dx[i]][y + dy[i]] == -1) {
						q.add(Pair.of(x + dx[i], y + dy[i]));
						map[x + dx[i]][y + dy[i]] = map[x][y] + 1;
					}
				}
			}
			System.out.println(map[m][n]);
		}
	}

	public static class Pair {
		private final int first;
		private final int second;

		public static Pair of(int first, int second) {
			return new Pair(first, second);
		}

		private Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		public int getFirst() {
			return first;
		}

		public int getSecond() {
			return second;
		}
	}
}
