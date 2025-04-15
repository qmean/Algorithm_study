import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		Queue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
			if (p1.end != p2.end) {
				return p1.end - p2.end;
			} else if (p1.start != p2.start) {
				return p1.start - p2.start;
			} else {
				return 0;
			}
		});

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
			String[] s;
			for (int i = 0; i <n ; i++) {
				s = br.readLine().split(" ");
				pq.add(Pair.of(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
			}
		}

		void solve() throws Exception{
			init();
			int cnt = 0;
			int end = 0;
			// pq.stream().forEach(p -> System.out.println(p.start + ":" + p.end));
			while (!pq.isEmpty()) {
				Pair cur = pq.poll();
				if (cur.start >= end) {
					end = cur.end;
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

	public static class Pair {
		int start;
		int end;

		public static Pair of(int start, int end) {
			return new Pair(start, end);
		}

		private Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
