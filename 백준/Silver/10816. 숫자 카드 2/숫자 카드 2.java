import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		new Boj10816Solution().solve();
	}

	static class Boj10816Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[20000001];
		Map<Integer, Integer> map = new HashMap<>();

		void init() throws Exception {
			int n = Integer.parseInt(br.readLine());
			Arrays.fill(arr, 0);
			String[] split = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(split[i]);
				arr[num + 10000000] ++;
				// map.put(num, map.getOrDefault(num, 0) + 1);
			}
		}

		void solve() throws Exception {
			init();
			int m = Integer.parseInt(br.readLine());
			String[] split = br.readLine().split(" ");
			for (int i = 0; i < m; i++) {
				int p = Integer.parseInt(split[i]);
				bw.write(String.valueOf(arr[p + 10000000])+ " ");
				//bw.flush();
			}
			bw.newLine();
			bw.flush();
		}
	}
}
