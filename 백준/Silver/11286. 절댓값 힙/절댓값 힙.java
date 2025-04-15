import java.io.*;
import java.util.Comparator;
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
		Queue<Integer> pq = new PriorityQueue<>((i1,i2) -> {
			if (Math.abs(i1) > Math.abs(i2)) {
				return 1;
			} else if (Math.abs(i1) < Math.abs(i2)) {
				return -1;
			} else if (i1 < i2) {
				return -1;
			} else if (i1 > i2) {
				return 1;
			}
			return 0;
		});

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i <n ; i++) {
				int n = Integer.parseInt(br.readLine());
				if (n == 0) {
					if (pq.isEmpty()) {
						bw.write("0\n");
					} else {
						bw.write(pq.poll() + "\n");
					}
				} else {
					pq.add(n);
				}
				bw.flush();
			}
		}

		void solve() throws Exception{
			init();
		}
	}
}
