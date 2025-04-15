import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		new Boj1966Solution().solve();
	}
	static class Boj1966Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new ArrayDeque<>();
		int t;
		int n, m;
		int target, targetIdx;
		Map<Integer, Integer> priorityMap = new HashMap<>();

		void solve() throws  Exception {
			t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				queue.clear();
				String[] s = br.readLine().split(" ");
				n = Integer.parseInt(s[0]);
				m = Integer.parseInt(s[1]);
				String[] s1 = br.readLine().split(" ");
				priorityMap.clear();
				for (int j = 0; j < n; j++) {
					int a = Integer.parseInt(s1[j]);
					int count = priorityMap.getOrDefault(a, 0);
					priorityMap.put(a, count + 1);
					queue.add(a);
				}
				target = Integer.parseInt(s1[m]);
				targetIdx = m;
				solution();
			}
		}

		void solution() throws IOException {
			boolean printed = false;
			int printCount = 0;
			while (!printed) {
				int i = queue.poll();
				if (i == priorityMap.entrySet().stream().max(Map.Entry.comparingByKey()).get().getKey()) {
					if (priorityMap.get(i) - 1 == 0)
						priorityMap.remove(i);
					else
						priorityMap.put(i, priorityMap.get(i) - 1);
					printCount++;
					if (targetIdx == 0) {
						printed = true;
					}
					else {
						targetIdx--;
					}
				}
				else {
					queue.add(i);
					targetIdx = targetIdx == 0 ? queue.size() - 1 : targetIdx - 1;
				}
			}
			bw.write(String.valueOf(printCount) + "\n");
			bw.flush();
		}
	}
}
