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
		int a, b;

		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			a = Integer.parseInt(s[0]);
			b = Integer.parseInt(s[1]);
		}

		void solve() throws Exception{
			init();
			Set<Long> set = new HashSet<>();
			set.add((long)a);
			int cnt = 0;
			boolean found = false;
			while (!set.isEmpty()) {
				List<Long> list = set.stream().collect(Collectors.toList());
				set.clear();
				for (Long i : list) {
					if (i == b) {
						found = true;
						break;
					}
					if (i * 10 + 1 <= b) {
						set.add(i * 10 + 1);
					}
					if (i * 2 <= b) {
						set.add(i * 2);
					}
				}
				if (found) {
					break;
				}
				cnt++;
			}
			if (found) {
				System.out.println(cnt + 1);
			} else {
				System.out.println(-1);
			}
		}
	}
}
