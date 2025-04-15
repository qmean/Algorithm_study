import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] visited = new boolean[10000];
		String[] ans = new String[10000];
		int t,a,b;
		char[] op = {'D', 'S', 'L', 'R'};

		void init() throws Exception{
			t = Integer.parseInt(br.readLine());
		}

		void solve() throws Exception{
			init();
			for (int i = 0; i < t; i++) {
				Arrays.fill(visited, false);
				Arrays.fill(ans, "");
				String[] s = br.readLine().split(" ");
				a = Integer.parseInt(s[0]);
				b = Integer.parseInt(s[1]);
				solution();
			}
		}

		void solution() {
			Set<Integer> set = new HashSet<>();
			set.add(a);
			visited[a] = true;
			while (!set.isEmpty()) {
				List<Integer> list = set.stream().collect(Collectors.toList());
				set.clear();
				boolean find = false;
				for (Integer i : list) {
					for (int j = 0; j < 4; j++) {
						int result = operation(op[j], i);
						if (!visited[result]) {
							visited[result] = true;
							set.add(result);
							ans[result] = ans[i] + op[j];
							if (result == b) {
								find = true;
							}
						}
					}
				}
				if (find) {
					break;
				}
			}
			System.out.println(ans[b]);
		}

		int operation(char c, int i) {
			if (c == 'D') {
				if (i * 2 > 9999) {
					return i * 2 % 10000;
				} else
					return i * 2;
			}
			else if (c == 'S') {
				if (i == 0) {
					return 9999;
				} else {
					return i - 1;
				}
			}
			else if (c == 'L') {
				int tmp = i / 1000;
				i = (i % 1000) * 10;
				return i + tmp;
			}
			else {
				int tmp = i % 10;
				i = (i / 10);
				return tmp * 1000 + i;
			}
		}
	}
}
