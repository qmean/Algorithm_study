import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;

		void init() throws Exception{
			s = br.readLine();
		}

		void solve() throws Exception{
			init();
			String[] split = s.split("-");
			List<Integer> list = new ArrayList<>();
			for (String str : split) {
				String[] plus = str.split("\\+");
				Integer sum = 0;
				for (String p : plus) {
					sum += Integer.parseInt(p);
				}
				list.add(sum);
			}
			Integer result = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				result -= list.get(i);
			}

			bw.write(result + "\n");
			bw.flush();
		}
	}
}
