import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n,m,v;
		boolean[][] graph;
		boolean[] visited;

		void init() throws Exception{
			String[] s = br.readLine().split(" ");

			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			v = Integer.parseInt(s[2]);

			graph = new boolean[n + 1][n + 1];
			visited = new boolean[n + 1];

			Arrays.fill(visited, false);

			int a,b;
			for (int i = 0; i < m; i++) {
				s = br.readLine().split(" ");
				a = Integer.parseInt(s[0]);
				b = Integer.parseInt(s[1]);
				graph[a][b] = true;
				graph[b][a] = true;
			}
		}

		void solve() throws Exception{
			init();
			dfs(v);
			bw.write("\n");
			bw.flush();
			Arrays.fill(visited, false);
			bfs(v);
			bw.flush();
		}

		void dfs(int i) throws IOException {
			if (visited[i])
				return ;
			bw.write(i + " ");
			visited[i] = true;
			for (int j = 1; j <= n; j++) {
				if (graph[i][j]) {
					dfs(j);
				}
			}
		}

		void bfs(int i) throws Exception {
			Deque<Integer> q = new ArrayDeque<>();
			q.addLast(i);

			while (!q.isEmpty()) {
				int cur = q.poll();
				if (!visited[cur])
					bw.write(cur + " ");
				visited[cur] = true;
				for (int j = 1; j <= n; j++) {
					if (graph[cur][j] && !visited[j])
						q.add(j);
				}
			}
		}
	}
}
