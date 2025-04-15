import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws Exception{
		new Solve().solve();
	}

	static class Solve {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;

		void init() throws IOException {
			n = Integer.parseInt(br.readLine());
		}

		void solve() throws Exception {
			init();
			int count10 = 0;
			int count5 = 0;
			int count2 = 0;
			for (int i = 2; i <= n; i++) {
				int a = i;
				while (true) {
					if (a % 10 == 0) {
						count10++;
						a/= 10;
					} else if (a % 5 == 0) {
						count5++;
						a/= 5;
					} else if (a % 2 == 0) {
						count2++;
						a /= 2;
					} else {
						break;
					}
				}
			}
			count10 += Math.min(count5, count2);
			bw.write(String.valueOf(count10));
			bw.newLine();
			bw.flush();
		}
	}
}
