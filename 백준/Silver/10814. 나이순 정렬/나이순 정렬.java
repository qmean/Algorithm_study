import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Main {
	public static void main(String[] args) throws Exception{
		new Solve().solve();
	}

	static class Solve {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;

		void solve() throws Exception {
			n = Integer.parseInt(br.readLine());
			Map<Integer, List<String>> map = new HashMap<>();
			int a;
			String name;
			for (int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				a = Integer.parseInt(s[0]);
				name = s[1];
				if (map.get(a) == null) {
					List<String> arr = new ArrayList<>();
					arr.add(name);
					map.put(a, arr);
				} else {
					map.get(a).add(name);
				}
			}

			map.entrySet().stream().forEach(e -> {
				try {
					print(e);
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			});
		}

		void print(Map.Entry<Integer, List<String>> entry) throws  Exception{
			Integer key = entry.getKey();
			for (String str : entry.getValue()) {
				bw.write(String.valueOf(key));
				bw.write(" " + str);
				bw.newLine();
				bw.flush();
			}
		}
	}
}
