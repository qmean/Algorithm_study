import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.Key;

class Main {
	public static void main(String[] args) throws Exception{
		new Solve().solve();
	}

	static class Solve {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int k;

		void init() throws Exception{
			String[] split = br.readLine().split(" ");
			n = Integer.parseInt(split[0]);
			k = Integer.parseInt(split[1]);
		}

		void solve() throws  Exception{
			init();
			int p = n-k;
			int a = 1;
			int b = 1;
			int c = 1;

			while (n > 0) {
				a= a * n;
				n--;
			}

			while (k > 0) {
				b= b *k;
				k--;
			}

			while (p > 0) {
				c*=p;
				p--;
			}

			bw.write(String.valueOf(a / (b * c)));
			bw.newLine();
			bw.flush();
		}
	}
}
