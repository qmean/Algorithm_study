import java.io.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;
		int[][] map;
		int[][] visit;
		int xStart, yStart;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		void init() throws Exception {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			map = new int[m + 1][n + 1];
			visit = new int[m + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				s = br.readLine().split(" ");
				for (int j = 1; j <= m; j++) {
					map[j][i] = Integer.parseInt(s[j - 1]);
					if (map[j][i] == 2) {
						xStart = j;
						yStart = i;
					} else if (map[j][i] == 0) {
						visit[j][i] = -1;
					}
				}
			}
		}

		void solve() throws Exception {
			init();
			Set<Pair> set = new HashSet<>();
			set.add(Pair.of(xStart, yStart));
			visit[xStart][yStart] = -1;
			int cnt = 1;
			while (!set.isEmpty()) {
				List<Pair> list = set.stream().collect(Collectors.toList());
				set.clear();
				for(Pair cur : list) {
					visit[cur.x][cur.y] = cnt;
					for (int i = 0; i < 4; i++) {
						if (cur.x + dx[i] <= 0 || cur.x + dx[i] > m || cur.y + dy[i] <= 0 || cur.y + dy[i] > n
							|| visit[cur.x + dx[i]][cur.y + dy[i]] != 0 || map[cur.x + dx[i]][cur.y + dy[i]] == 0) {
							continue;
						}
						set.add(Pair.of(cur.x + dx[i], cur.y + dy[i]));
					}
				}
				cnt++;
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (visit[j][i] == -1) {
						bw.write(String.valueOf(0));
					} else
						bw.write(String.valueOf(visit[j][i] - 1));
					if (j != m) {
						bw.write(" ");
					}
				}
				bw.write("\n");
				bw.flush();
			}
		}
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public static Pair of(int x, int y) {
			return new Pair(x, y);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			Pair pair;
			if (!(o instanceof Pair))
				return false;
			else
				pair = (Pair)o;
			return x == pair.x && y == pair.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
