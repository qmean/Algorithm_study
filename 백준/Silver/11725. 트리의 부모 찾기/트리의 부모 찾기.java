import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
		int n;
		int[] parent;
		List<Set<Integer>> map = new ArrayList<>();

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i <= n; i++) {
				map.add(new HashSet<>());
			}
			parent = new int[n + 1];
			for (int i = 0; i <n-1 ; i++) {
				String[] s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				map.get(a).add(b);
				map.get(b).add(a);
			}
		}

		void solve() throws Exception{
			init();
			Deque<Integer> q = new ArrayDeque<>();
			q.add(1);
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (Integer i : map.get(cur)) {
					parent[i] = cur;
					map.get(i).remove(cur);
					q.add(i);
				}
			}
			for (int i = 2; i <= n; i++) {
				bw.write(String.valueOf(parent[i]) + "\n");
			}
			bw.flush();
		}
	}
}
