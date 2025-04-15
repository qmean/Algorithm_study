import java.io.*;
import java.util.Comparator;
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
		Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
		}

		void solve() throws Exception{
			init();
			for (int i = 0; i < n; i++) {
				int cmd = Integer.parseInt(br.readLine());
				if (cmd == 0) {
					bw.write(q.isEmpty() ? "0\n" : q.poll() + "\n");
				} else {
					q.add(cmd);
				}
				bw.flush();
			}
		}
	}
}
