import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> prime = new ArrayList<>();
		List<Long> sum = new ArrayList<>();
		boolean[] skip = new boolean[4_000_001];
		int cnt = 0;
		int n;

		void init() throws Exception {
			int idx = 6;
			n = Integer.parseInt(br.readLine());
			sum.add(0L);
			prime.add(2);
			mark(2);
			sum.add(sum.get(sum.size() - 1) + 2);
			prime.add(3);
			sum.add(sum.get(sum.size() - 1) + 3);
			mark(3);
			while (idx <= 4_000_000) {
				if (!skip[idx - 1] && isPrime(idx - 1)) {
					mark(idx - 1);
					prime.add(idx - 1);
					sum.add(sum.get(sum.size() - 1) + idx - 1);
				}
				if (!skip[idx + 1] && isPrime(idx + 1)) {
					mark(idx + 1);
					prime.add(idx + 1);
					sum.add(sum.get(sum.size() - 1) + idx + 1);
				}
				idx += 6;
			}
		}

		void solve() throws Exception {
			init();
			int arrSize = sum.size();
			int p1 = 0;
			int p2 = 0;
			while (p1 < arrSize && p2 < arrSize){
				if (sum.get(p2) - sum.get(p1) == n) {
					cnt++;
					p1++;
				} else if (sum.get(p2) - sum.get(p1) < n) {
					p2++;
				} else {
					p1++;
				}
			}
			bw.write(String.valueOf(cnt));
			bw.flush();
		}

		boolean isPrime(int i) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					return false;
				}
			}
			return true;
		}

		void mark(int i) {
			int tmp = i;
			while (tmp <= 4_000_000) {
				skip[tmp] = true;
				tmp += i;
			}
		}
	}
}
