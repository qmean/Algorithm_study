import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Solution solution = new Solution();
		solution.init();
		solution.solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		List<Integer> list = new ArrayList<>();

		void init() throws IOException {
			n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(s[i]));
			}
			br.close();
		}

		void solve() throws Exception {
			int cal = 0;
			list.sort(Comparator.naturalOrder());
			List<Long> ans = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (i != 0) {
					ans.add(list.get(i) + ans.get(i - 1));
				} else {
					ans.add(list.get(i).longValue());
				}
				cal += ans.get(i);
			}
			bw.write(String.valueOf(cal));
			bw.flush();
		}
	}
}
