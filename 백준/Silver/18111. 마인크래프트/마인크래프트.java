import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m, b;
		List<Integer> list = new ArrayList<>();

		void init() throws Exception {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			b = Integer.parseInt(s[2]);
			for (int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					list.add(Integer.parseInt(s[j]));
				}
			}
		}

		void solve() throws Exception {
			init();

			int max = (list.stream().mapToInt(i -> i).sum() + b) / list.size();
			max = Math.min(max, 256);
			int min = list.stream().min(Comparator.naturalOrder()).get();

			Map<Integer, Integer> ans = new HashMap<>();
			long minValue = Long.MAX_VALUE;
			int idx = 0;
			for (int i = min; i <= max ; i++) {
				int tmp = calculate(i);
				if (tmp <= minValue) {
					minValue = tmp;
					idx = i;
				}
			}
			bw.write(minValue + " " + idx + "\n");
			bw.flush();
		}

		int calculate(int h) {
			return list.stream().mapToInt(i -> {
				if (i > h) {
					return (i - h) * 2;
				} else {
					return (h - i);
				}
			}).sum();
		}
	}
}
