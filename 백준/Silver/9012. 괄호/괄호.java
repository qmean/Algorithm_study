import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		new Boj9012Solution().solve();
	}

	static class Boj9012Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		int t;
		Stack<Character> stk = new Stack<>();

		void init() throws IOException {
			t = Integer.parseInt(br.readLine());
		}

		void solve() throws IOException {
			init();
			for (int i = 0; i < t; i++) {
				str = br.readLine();
				if (isVPS()) {
					bw.write("YES\n");
					bw.flush();
				} else {
					bw.write("NO\n");
					bw.flush();
				}
			}
		}

		private boolean isVPS() {
			stk.clear();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(') {
					stk.push(c);
				} else if (c == ')') {
					if (stk.isEmpty()) {
						return false;
					} else if (stk.lastElement() == '(') {
						stk.pop();
					} else {
						return false;
					}
				}
			}
			return stk.isEmpty();
		}
	}
}
