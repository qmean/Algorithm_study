import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}

	static class Solution {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m;
		Set<Integer> set = new HashSet<>();
		String[] s;

		void init() throws IOException {
			m = Integer.parseInt(br.readLine());
		}

		void solve() throws IOException {
			init();
			for (int i = 0; i < m; i++) {
				s = br.readLine().split(" ");
				if (Objects.equals(s[0], "all")) {
					for (int j = 0; j < 20; j++) {
						set.add(j + 1);
					}
				} else if (Objects.equals(s[0], "empty")) {
					set.clear();
				} else {
					int x = Integer.parseInt(s[1]);
					if (Objects.equals(s[0], "add")) {
						set.add(x);
					} else if (Objects.equals(s[0], "remove")) {
						set.remove(x);
					} else if (Objects.equals(s[0], "check")) {
						bw.write(set.contains(x) ? "1\n" : "0\n");
					} else if (Objects.equals(s[0], "toggle")) {
						if (set.contains(x)) {
							set.remove(x);
						} else {
							set.add(x);
						}
					}
				}
			}
			bw.flush();
		}
	}
}
