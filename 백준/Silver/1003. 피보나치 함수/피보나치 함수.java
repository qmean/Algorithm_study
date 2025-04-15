import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().init();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int[] zero = new int[43];
		int[] one = new int[43];

		void init() throws Exception {
			n = Integer.parseInt(br.readLine());
			Arrays.fill(one, -1);
			Arrays.fill(zero, -1);
			zero[0] = 1;
			zero[1] = 0;
			one[0] = 0;
			one[1] = 1;
			for (int i = 0; i <n ; i++) {
				solve();
			}
			bw.flush();
		}

		void solve() throws Exception {
			int inp = Integer.parseInt(br.readLine());
			fibonacci(inp);
			bw.write(zero[inp] + " " + one[inp] + "\n");
			bw.flush();
		}

		void fibonacci(int n) {
			if (n == 0 || n == 1) {
				return ;
			}
			if (zero[n - 1] == -1 || one[n - 1] == -1) {
				fibonacci(n-1);
			}
			if (zero[n - 2] == -1 || one[n - 2] == -1) {
				fibonacci(n - 2);
			}
			zero[n] = zero[n - 1] + zero[n - 2];
			one[n] = one[n - 1] + one[n - 2];
		}
	}
}
