import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		new Boj18110Solution().solve();
	}

	static class Boj18110Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> pq = new PriorityQueue<>();
		List<Integer> arr = new ArrayList<>();
		int n;
		double sum = 0;

		void solve() throws IOException {
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				bw.write("0\n");
				bw.flush();
				return;
			}
			double dn = n;
			long pivot = Math.round(dn * 0.15);
			for (int i = 1; i <= n; i++) {
				arr.add(Integer.parseInt(br.readLine()));
			}
			Collections.sort(arr);
			for (int i = 0; i < n; i++) {
				if (i < pivot || i >= n - pivot) {
					continue;
				}
				sum += arr.get(i);
			}
			double b = n - 2 * pivot;
			long print = Math.round(sum / b);
			bw.write(String.valueOf(print) + "\n");
			bw.flush();
		}
	}
}
