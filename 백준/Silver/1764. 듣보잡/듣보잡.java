
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Set<String> d = new HashSet<>();
		Set<String> b = new HashSet<>();
		int n, m;

		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			for (int i = 0; i < n; i++) {
				d.add(br.readLine());
			}
			for (int i = 0; i < m; i++) {
				b.add(br.readLine());
			}
		}

		void solve() throws Exception{
			init();
			d.retainAll(b);
			bw.write(String.valueOf(d.size()) + "\n");
			d.stream()
				.sorted()
				.forEach(x -> {
				try {
					bw.write(x + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			bw.flush();
		}
	}
}
