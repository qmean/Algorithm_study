import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n,m;
		String s;

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			s = br.readLine();
		}

		void solve() throws Exception{
			init();
			int cnt = 0;
			for (int i = 0; i < m; i++) {
				if (s.charAt(i) != 'I')
					continue;
				int k = 0;
				for (int j = i+1; j < m-1; j+=2) {
					if (s.charAt(j) == 'O' && s.charAt(j+1) == 'I')
						k++;
					else
						break;
				}
				if (k >= n) {
					cnt+= k-n + 1;
				}
				i+=k*2;
			}
			bw.write(String.valueOf(cnt));
			bw.flush();
		}
	}
}
