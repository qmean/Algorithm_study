import java.awt.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Solution
{
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) throws Exception
	{
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			solve(test_case);
		}
	}

	static int[][] map;
	static boolean[][] visited;
	static int n;
	static int[] dx = {-1,-1,-1,0, 0,1, 1,1};
	static int[] dy = {-1,0, 1, -1,1,-1,0,1};

	static void solve(int t) {
		n = sc.nextInt();
		map = new int[n+2][n+2];
		visited = new boolean[n+2][n+2];
		for (int i = 1; i <= n; i++) {
			String s = sc.next();
			for (int j = 1; j <= n; j++) {
				if (s.charAt(j-1) == '*')
					map[i][j] = Integer.MIN_VALUE;
				else
					map[i][j] = 0;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] >= 0)
					continue;
				for (int k = 0; k < 8; k++) {
					map[i+dx[k]][j+dy[k]]++;
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					bfs(i, j, 0);
					cnt++;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] > 0 && !visited[i][j]) {
					cnt++;
				}
			}
		}

		System.out.format("#%d %d\n", t, cnt);
	}

	static void bfs(int x, int y, int val) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		if (val != 0)
			return ;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 1 || ny < 1 || nx > n || ny > n || visited[nx][ny] || map[nx][ny] < 0)
					continue;
				if (map[nx][ny] == 0) {
					q.add(new Point(nx, ny));
				}
				visited[nx][ny] = true;
			}
		}
	}
}
