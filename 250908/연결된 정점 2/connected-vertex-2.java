import java.util.Scanner;
public class Main {

    static int[] uf;
    static int[] cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        uf = new int[100_000];
        cnt = new int[100_000];
        for (int i = 0; i < 100_000; i++) {
            uf[i] = i;
            cnt[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            union(a,b);
            System.out.println(cnt[find(a)]);
        }
    }

    static int find(int f) {
        if (uf[f] == f)
            return f;
        uf[f] = find(uf[f]);
        return uf[f];
    }

    static void union(int a, int b) {
        int ar = find(a);
        int br = find(b);

        if (ar == br)
            return;
        uf[ar] = br;
        cnt[br] += cnt[ar];
    }
}