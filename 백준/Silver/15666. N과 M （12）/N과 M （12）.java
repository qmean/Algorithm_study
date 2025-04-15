import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;
		int[] arr;
		SortedSet<Integer> set = new TreeSet<>();
		List<Integer> list;


		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);

			s = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				set.add(Integer.parseInt(s[i]));
			}
		}

		void solve() throws Exception{
			init();
			list = set.stream().collect(Collectors.toList());
			for (int i = 0; i < list.size(); i++) {
				cond(i, 1, "");
			}
		}

		private void cond(int cur, int depth, String str) throws IOException {
			if (depth == m) {
				bw.write(str + list.get(cur) + "\n");
				bw.flush();
				return ;
			}
			String tmp = str + list.get(cur) + " ";
			for (int i = cur; i < list.size(); i++) {
				cond(i, depth + 1, tmp);
			}
		}
	}
}
