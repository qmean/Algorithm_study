import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int n;
	static int m;
	static int[] uf;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		String[] s = br.readLine().split(" ");		
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		uf = new int[n];
		for (int i = 0; i < n; i++) {
			uf[i] = i;
		}
		
		boolean valid = true;
		int prt = 0;
		for (int i = 0; i < m; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			if (valid && !union(a, b)) {
				valid = false;
				prt = i+1;
			}
		}

		System.out.println(prt);
	}

	public static boolean union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		if (ar == br)
			return false;
		uf[ar] = br;
		return true;
	}

	public static int find(int f) {
		if (uf[f] == f)
			return f;
		uf[f] = find(uf[f]);
		return uf[f];
	}

}
