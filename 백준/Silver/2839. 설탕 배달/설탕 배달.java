import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		new Boj2839Solve().solve();
	}

	static class Boj2839Solve {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t;
		void init() throws Exception {
			t = Integer.parseInt(br.readLine());
		}

		void solve() throws Exception {
			init();

			int five = t/5;
			int print = -1;
			for(int i = 0; i <= five; i++) {
				if ((t - 5 * i) % 3 == 0) {
					print = i + (t - 5 * i) / 3;
				}
			}

			bw.write(String.valueOf(print));
			bw.newLine();
			bw.flush();
		}
	}
}
