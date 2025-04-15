import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;
		List<Integer> list = new ArrayList<>();
		SortedSet<List<Integer>> set = new TreeSet<>((l1, l2) -> {
			for (int i = 0; i < m; i++) {
				if (l1.get(i) != l2.get(i)) {
					return l1.get(i) - l2.get(i);
				}
			}
			return 0;
		});

		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			s = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(s[i]));
			}
			list.sort(Comparator.naturalOrder());
		}

		void solve() throws Exception{
			init();
			for (int i = 0; i < n; i++) {
				HashSet<Integer> paramSet = new HashSet<>();
				paramSet.add(i);
				cond(1, i, new ArrayList<>(), paramSet);
			}
			int cur = 1;
			for (List<Integer> list : set) {
				for (int i = 0; i < list.size(); i++) {
					bw.write(String.valueOf(list.get(i)));
					if (i != list.size() - 1) {
						bw.write(" ");
					}
				}
				// if (cur != set.size())
					bw.write("\n");
				bw.flush();
				cur++;
			}
			bw.flush();
		}

		void cond(int depth, int cur, List<Integer> curList, Set<Integer> anserSet) throws IOException {
			if (depth == m) {
				List<Integer> addList = new ArrayList<>(curList);
				addList.add(list.get(cur));
				set.add(addList);
				return ;
			}
			List<Integer> tmpList = new ArrayList<>(curList);
			tmpList.add(list.get(cur));
			for (int i = 0; i < n; i++) {
				if (anserSet.contains(i))
					continue;
				HashSet<Integer> paramSet = new HashSet<>(anserSet);
				paramSet.add(i);
				cond(depth + 1, i , tmpList, paramSet);
			}
		}
	}
}
