import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		new Boj1654Solution().solve();
	}
	static class Boj1654Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k, n;
		List<Integer> list = new ArrayList<>();

		void solve() throws IOException {
			String[] s = br.readLine().split(" ");
			k = Integer.parseInt(s[0]);
			n = Integer.parseInt(s[1]);

			Long sum = 0L;
			for (int i = 0; i < k; i++) {
				int a = Integer.parseInt(br.readLine());
				sum+=a;
				list.add(a);
			}

			Long min = 0L;
			Long max = sum/n;
			if (check(max)) {
				bw.write(String.valueOf(max) + "\n");
				bw.flush();
				return;
			}
			while (true) {
				Long mid = (min + max) / 2;
				if (check(mid)) {
					if (checkMax(mid)) {
						bw.write(String.valueOf(mid) + "\n");
						break;
					} else
						min = mid;
				} else {
					max = mid;
				}
			}
			bw.flush();
		}

		boolean check(Long i) {
			if (i == 0) {
				return true;
			}
			int reduce = 0;
			for (int a : list) {
				reduce += a/i;
			}
			return reduce >= n;
		}

		boolean checkMax(Long i) {
			return !check(i+1);
		}
	}
}
