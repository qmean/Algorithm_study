import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int dx[] = {0, 0, -1, 1};
		final int dy[] = {-1, 1, 0, 0};
		final char EMPTY = '.';
		final char WATER = '*';
		final char STONE = 'X';
		final char SRC = 'S';
		final char NEXT_WATER = '#';
		final char DEST = 'D';

		char[][] map;
		boolean[][] visited;
		int r, c;
		Point src;

		void init() throws Exception {
			String[] s = br.readLine().split(" ");
			r = Integer.parseInt(s[0]);
			c = Integer.parseInt(s[1]);

			map = new char[r][c];
			visited = new boolean[r][c];

			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				for (int j = 0; j < c; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == SRC) {
						src = new Point(i, j);
					}
				}
			}

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == WATER) {
						markingNextWater(i,j);
					}
				}
			}
		}

		void solve() throws Exception {
			init();
			int time = 0;
			Deque<Point> q = new ArrayDeque<>();
			q.add(src);
			visited[src.x][src.y] = true;
			while (!q.isEmpty()) {
				Point[] arr = q.toArray(new Point[0]);
				q.clear();
				time++;

				// 이동하기
				for (Point cur : arr) {
					for (int i = 0; i < 4; i++) {
						int nx = cur.x + dx[i];
						int ny = cur.y + dy[i];

						// 범위 벗어나는지 검사
						if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
						// 돌, 물, 다음에 물 검사
						if (map[nx][ny] == WATER || map[nx][ny] == STONE || map[nx][ny] == NEXT_WATER) continue;
						// 종료조건 만나는 경우
						if (map[nx][ny] == DEST) {
							System.out.println(time);
							return ;
						}
						// 다음칸으로 이동하는 경우
						if (!visited[nx][ny]) {
							visited[nx][ny] = true;
							q.add(new Point(nx, ny));
						}
					}
				}

				// 물채우기
				fillWater();
			}

			System.out.println("KAKTUS");
		}

		void markingNextWater(int x, int y) {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
				if (map[nx][ny] == EMPTY) map[nx][ny] = NEXT_WATER;
			}
		}

		void fillWater() {
			List<Point> list = new ArrayList<>();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == NEXT_WATER) {
						map[i][j] = WATER;
						list.add(Point.of(i,j));
					}
				}
			}
			for (Point p : list) {
				markingNextWater(p.x, p.y);
			}
		}

		static class Point {
			int x;
			int y;

			public static Point of(int x, int y) {
				return new Point(x, y);
			}

			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
	}
}
