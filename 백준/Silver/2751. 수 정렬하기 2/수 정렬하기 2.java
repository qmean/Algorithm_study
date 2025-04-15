import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;

class Main {
	public static void main(String[] args) throws Exception{
		new Solve().solve();
	}

	static class Solve {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		void solve() throws Exception {
			int n = Integer.parseInt(br.readLine());
			BitSet bitSet = new BitSet(2000001);
			for (int i = 0; i < n; i++) {
				bitSet.set(Integer.parseInt(br.readLine()) + 1000000);
			}
			for (int i = 0; i <= 2000001; i++) {
				if (bitSet.get(i)) {
					bw.write(String.valueOf(i - 1000000));
					bw.newLine();
					bw.flush();
				}
			}
		}
	}
}
