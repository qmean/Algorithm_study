import java.io.*;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// Queue<Integer> minQ = new PriorityQueue<>(Comparator.naturalOrder());
		// Queue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
		SortedSet<Integer> set = new TreeSet<>(Comparator.naturalOrder());
		TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.naturalOrder());
		int t;

		void init() throws Exception {
			t = Integer.parseInt(br.readLine());
		}

		void solve() throws Exception {
			init();
			for (int i = 0; i < t; i++) {
				int k = Integer.parseInt(br.readLine());
				map.clear();
				for (int j = 0; j < k; j++) {
					String[] s = br.readLine().split(" ");
					if (s[0].charAt(0) == 'I') {
						int tmp = Integer.parseInt(s[1]);
						map.put(tmp, map.getOrDefault(tmp, 0) + 1);
					} else {
						int tmp = Integer.parseInt(s[1]);
						if (map.isEmpty())
							continue;
						if (tmp == -1) {
							Integer value = map.firstEntry().getValue();
							if (value == 1) {
								map.remove(map.firstKey());
							} else {
								map.put(map.firstKey(), map.get(map.firstKey()) - 1);
							}
						} else if (tmp == 1) {
							Integer value = map.lastEntry().getValue();
							if (value == 1) {
								map.remove(map.lastKey());
							} else {
								map.put(map.lastKey(), map.get(map.lastKey()) - 1);
							}
						}
					}
				}
				if (map.isEmpty()) {
					System.out.println("EMPTY");
				} else {
					System.out.println(map.lastKey() + " " + map.firstKey());
				}
			}
		}
	}
}
