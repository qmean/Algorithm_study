import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		new Boj4949Solution().solution();
	}

	static class Boj4949Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		Stack<Character> queue = new Stack<>();

		void solution() throws Exception {
			while (true) {
				queue.clear();
				str = br.readLine();
				if (str.equals("."))
					break;
				else if (str.charAt(str.length() - 1) != '.')
					str = str.concat(br.readLine());
				solve();
			}
		}

		void solve() throws Exception {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				char a;
				if (c == '(' || c == '[') {
					queue.push(c);
				} else if (!queue.isEmpty() && c == ')') {
					a = queue.pop();
					if (a != '(') {
						bw.write("no\n");
						bw.flush();
						return;
					}
				} else if (!queue.isEmpty() && c == ']') {
					a = queue.pop();
					if (a != '[') {
						bw.write("no\n");
						bw.flush();
						return;
					}
				} else if (queue.isEmpty() && (c == ')' || c == ']')) {
					bw.write("no\n");
					bw.flush();
					return;
				}
			}
			if (queue.isEmpty())
				bw.write("yes\n");
			else
				bw.write("no\n");
			queue.clear();
			bw.flush();
		}
	}
}
