import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int[] fruit;

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
			fruit = new int[n];
			String[] s = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				int tmp = Integer.parseInt(s[i]);
				fruit[i] = tmp;
			}
		}

		void solve() throws Exception{
			init();
			int max = 0;
			for (int i = 1; i < 10; i++) {
				// 1개일 경우 체크
				int check = check(i, i);
				if (max < check) {
					max = check;
				}
				// 2개일 경우 체크
				for (int j = i+1; j <10 ; j++) {
					check = check(i, j);
					if (max < check) {
						max = check;
					}
				}
			}
			bw.write(max + "\n");
			bw.flush();
		}

		int check(int f1, int f2) {
			int p1 = 0;
			int p2 = 0;
			int max = 0;
			while (p1 < n) {
				if (fruit[p1] == f1 || fruit[p1] == f2) {
					p2 = p1;
					while (p2 < n - 1) {
						if (fruit[p2 + 1] != f1 && fruit[p2 + 1] != f2) {
							break;
						}
						p2++;
					}
					if (max < p2 - p1 + 1) {
						max = p2 - p1 + 1;
					}
				}
				if (p1 <= p2)
					p1 = p2;
				p1++;
			}
			return max;
		}
	}

	public static class Pair {
		private final int start;
		private final int end;
		private final int size;

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public int getSize() {
			return size;
		}

		private Pair(int start, int end, int size) {
			this.start = start;
			this.end = end;
			this.size = size;
		}

		public static Pair of(int start, int end) {
			return new Pair(start, end, end - start + 1);
		}
	}
}
