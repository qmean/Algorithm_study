import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws IOException {
		new Solve().solve();
	}

	static class Solve {
		int n;
		long[] arr = new long[10001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		public void solve() throws IOException {
			n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				Integer s = Integer.parseInt(br.readLine());
				arr[s]++;
			}

			for (int i = 0; i <= 10000; i++) {
				for (int j = 0; j < arr[i]; j++) {
					bw.write(String.valueOf(i));
					bw.newLine();
				}
				bw.flush();
			}
			bw.flush();
		}
	}
}
