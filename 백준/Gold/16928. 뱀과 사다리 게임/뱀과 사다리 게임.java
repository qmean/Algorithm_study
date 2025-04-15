import java.io.*;
import java.util.HashSet;
import java.util.List;
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
		int[] map = new int[101];
		boolean[] visited = new boolean[101];

		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);

			for (int i = 0; i < n + m; i++) {
				s = br.readLine().split(" ");
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				map[start] = end - start;
			}
		}

		void solve() throws Exception{
			init();
			Set<Integer> set = new HashSet<>();
			int cnt = 0;
			boolean finished = false;
			set.add(1);
			while (!set.isEmpty() && !finished) {
				List<Integer> list = set.stream().collect(Collectors.toList());
				for (int cur : list) {
					visited[cur] = true;
					for (int j = 1; j <= 6; j++) {
						if (cur + j > 100 || visited[cur + j]) {
							continue;
						} else if (cur + j == 100) {
							finished = true;
						}
						visited[cur + j] = true;
						if (map[cur + j] != 0) {
							visited[cur + j + map[cur + j]] = true;
							set.add(cur + j + map[cur + j]);
						} else {
							set.add(cur + j);
						}
					}
				}
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
