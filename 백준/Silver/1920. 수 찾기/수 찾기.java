import  java.util.*;
import  java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;
		Set<Integer> set = new HashSet<>();

		void init() throws IOException {
			n = Integer.parseInt(br.readLine());
			String[] split = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				set.add(Integer.parseInt(split[i]));
			}
		}

		void solve() throws IOException {
			init();
			m = Integer.parseInt(br.readLine());
			String[] split = br.readLine().split(" ");
			for (int i = 0; i < m; i++) {
				if (set.contains(Integer.parseInt(split[i]))) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			}
			bw.flush();
		}

	}
}
