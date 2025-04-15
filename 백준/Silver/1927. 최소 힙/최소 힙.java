import java.io.*;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		Queue<Integer> q = new PriorityQueue<>(Comparator.naturalOrder());

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
		}

		void solve() throws Exception{
			init();
			for (int i = 0; i <n ; i++) {
				int n = Integer.parseInt(br.readLine());
				if (n == 0) {
					if (q.isEmpty()) {
						bw.write("0\n");
					} else {
						bw.write(q.poll() + "\n");
					}
				} else {
					q.add(n);
				}
			}
			bw.flush();
		}
	}
}
