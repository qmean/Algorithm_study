import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Tuple<T, R> {
	T t;
	R r;

	private Tuple(T t, R r) {
		this.t = t;
		this.r = r;
	}

	public static <T, R> Tuple<T, R> of(T t, R r) {
		return new Tuple<>(t, r);
	}

	public T first() {
		return t;
	}

	public R second() {
		return r;
	}
}

class Boj2609 {

	Map<Integer, Integer> nMap = new HashMap<>();
	Map<Integer, Integer> mMap = new HashMap<>();
	Integer n, m;
	Integer prime = 2;

	void init() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
	}

	void solve() {
		while (n != 1 || m != 1) {
			int ncount = 0;
			int mcount = 0;
			while (n % prime == 0) {
				n /= prime;
				ncount++;
			}
			while (m % prime == 0) {
				m /= prime;
				mcount++;
			}
			nMap.put(prime, ncount);
			mMap.put(prime, mcount);
			prime = findNextPrime();
		}

		long min = 1;
		long max = 1;

		Set<Map.Entry<Integer, Integer>> nSet = nMap.entrySet();

		for (Map.Entry<Integer, Integer> entry : nSet) {
			int n = nMap.get(entry.getKey());
			int m = mMap.get(entry.getKey());

			int max1 = Math.max(n, m);
			int min1 = Math.min(n, m);

			min *= Math.pow(entry.getKey(), min1);
			max *= Math.pow(entry.getKey(), max1);
			mMap.remove(entry.getKey());
		}

		Set<Map.Entry<Integer, Integer>> mSet = mMap.entrySet();

		for (Map.Entry<Integer, Integer> entry : mSet) {
			int n = nMap.get(entry.getKey());
			int m = mMap.get(entry.getKey());

			int max1 = Math.max(n, m);
			int min1 = Math.min(n, m);

			min *= Math.pow(entry.getKey(), min1);
			max *= Math.pow(entry.getKey(), max1);
		}

		System.out.println(min);
		System.out.println(max);
	}

	Integer findNextPrime() {
		prime += 1;
		while (true) {
			if (isPrime(prime)) {
				return prime;
			}
			prime++;
		}
	}

	boolean isPrime(Integer num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}

class Main {
	public static void main(String[] args) {
		Boj2609 b = new Boj2609();
		b.init();
		b.solve();
	}
}
