import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		List<Pair> pairs = new ArrayList<>();


		Comparator<Pair> comp = Comparator.naturalOrder();

		void init() throws IOException {
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] split = br.readLine().split(" ");
				pairs.add(Pair.of(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
			}
		}

		void solve() throws IOException {
			init();
			pairs.sort(comp);
			for (Pair pair : pairs) {
				bw.write(pair.getFirst() + " " + pair.getSecond() + "\n");
			}
			bw.flush();
		}

	}

	static class Pair implements Comparable<Pair> {
		Integer first;
		Integer second;

		private Pair(Integer first, Integer second) {
			this.first = first;
			this.second = second;
		}

		static Pair of(Integer first, Integer second) {
			return new Pair(first, second);
		}

		public Integer getFirst() {
			return first;
		}

		public Integer getSecond() {
			return second;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.second.compareTo(o.second) == 0) {
				return this.first.compareTo(o.first);
			} else {
				return this.second.compareTo(o.second);
			}
		}
	}
}
