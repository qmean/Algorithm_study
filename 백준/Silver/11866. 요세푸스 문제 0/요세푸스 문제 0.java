import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		new Boj11866Solution().solve();
	}

	static class Boj11866Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k;
		int n;
		List<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();

		void init() throws Exception {
			String[] split = br.readLine().split(" ");
			n = Integer.parseInt(split[0]);
			k = Integer.parseInt(split[1]);
			for (int i = 0; i < n; i++) {
				list.add(i + 1);
				queue.add(i + 1);
			}
		}

		void solve() throws Exception {
			init();
			int idx = k - 1;
			bw.write("<");
			while (list.size() != 1) {
				if (idx >= list.size()) {
					idx %= list.size();
				}
				bw.write(String.valueOf(list.remove(idx)) + ", ");
				idx = idx + k - 1;
			}
			bw.write(String.valueOf(list.get(0)) + ">\n");
			bw.flush();
		}
	}
}
