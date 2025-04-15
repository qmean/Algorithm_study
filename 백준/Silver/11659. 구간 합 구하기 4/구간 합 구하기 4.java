import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] arr;
		int n,m;

		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			arr = new long[n + 1];
			Arrays.fill(arr, 0);
			s = br.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				arr[i] = arr[i - 1] + Integer.parseInt(s[i - 1]);
			}
		}

		void solve() throws Exception{
			init();
			int i,j;
			for (int k = 0; k < m; k++) {
				String[] s = br.readLine().split(" ");
				i = Integer.parseInt(s[0]);
				j = Integer.parseInt(s[1]);
				bw.write((arr[j] - arr[i - 1]) + "\n");
				bw.flush();
			}
		}
	}
}
