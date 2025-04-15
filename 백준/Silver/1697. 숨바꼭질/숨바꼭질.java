import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, k;
		int[] find = new int[200001];

		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			k = Integer.parseInt(s[1]);
			Arrays.fill(find, -1);
		}

		void solve() throws Exception{
			init();
			Queue<Integer> q = new ArrayDeque<>();
			if (n > k) {
				System.out.println(n - k);
				return ;
			} else if (n == k) {
				System.out.println(0);
				return ;
			}
			q.add(n);
			find[n] = 0;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int i = -1; i < 2; i++) {
					int num;
					if (i == 0) {
						num = cur * 2;
					} else {
						num = cur + i;
					}

					if (num == k) {
						System.out.println(find[cur] + 1);
						return ;
					}
					else if (num < 0) continue;
					else if (num > 200000) continue;
					else if (find[num] != -1) continue;
					q.add(num);
					find[num] = find[cur] + 1;
				}
			}
		}
	}
}
