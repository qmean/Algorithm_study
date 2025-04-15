import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		List<Integer> list = new ArrayList<>();
		SortedMap<Integer, Integer> map = new TreeMap<>(Comparator.naturalOrder());

		void init() throws Exception {
			n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				int k = Integer.parseInt(s[i]);
				list.add(k);
				map.put(k, map.getOrDefault(k, 0) + 1);
			}
		}

		void solve() throws Exception {
			init();
			int before = 0;
			Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
			for (Map.Entry<Integer, Integer> e : entries) {
				int value = before;
				before = 1 + before;
				map.put(e.getKey(), value);
			}

			for (int i : list) {
				bw.write(map.get(i) + " ");
			}
			bw.flush();
		}
	}
}
