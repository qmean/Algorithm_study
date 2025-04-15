import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m, n;
		Set<Pair> set = new HashSet<>();
		int[][] map;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		int total = 0;
		int finished = 0;

		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			m = Integer.parseInt(s[0]);
			n = Integer.parseInt(s[1]);
			map = new int[m][n];

			for (int i = 0; i <n ; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j <m ; j++) {
					int a = Integer.parseInt(s[j]);
					if (a == 1) {
						set.add(Pair.of(j, i));
						finished++;
					}
					if (a != -1)
						total++;
					map[j][i] = a;
				}
			}
		}

		void solve() throws Exception{
			init();
			if (total == finished) {
				System.out.println(0);
				return ;
			}
			int time = 0;
			while (!set.isEmpty()) {
				List<Pair> list = set.stream().collect(Collectors.toList());
				set.clear();
				for (Pair p : list) {
					for (int i = 0; i < 4; i++) {
						if (p.x + dx[i] >= 0 && p.x + dx[i] < m && p.y + dy[i] >= 0 && p.y + dy[i] < n
							&& map[p.x + dx[i]][p.y + dy[i]] == 0) {
							map[p.x + dx[i]][p.y + dy[i]] = 1;
							set.add(Pair.of(p.x + dx[i], p.y + dy[i]));
						}
					}
				}
				finished += set.size();
				time++;
			}
			if (finished == total) {
				System.out.println(time - 1);
			} else {
				System.out.println(-1);
			}
		}
	}

	private static class Pair {
		int x;
		int y;

		public static Pair of(int x, int y) {
			return new Pair(x, y);
		}

		private Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			Pair p = (Pair)o;
			return p.x == x && p.y == y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
