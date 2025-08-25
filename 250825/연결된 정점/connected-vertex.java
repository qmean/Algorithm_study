import java.util.Scanner;
public class Main {

    static int[] uf;
    static int[] cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        uf = new int[n+1];
        cnt = new int[n+1];
        for(int i = 1; i <= n; i++) {
            uf[i] = i;
            cnt[i] = 1;
        }
        for(int i = 0; i < m; i++) {
            String str = sc.next();
            if (str.equals("x")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                union(a, b);
            } else {
                int a = sc.nextInt();
                int f = find(a);
                System.out.println(cnt[f]);
            }
        }
    }

    static int find(int f) {
        if (uf[f] == f) {
            return f;
        }
        int ret = find(uf[f]);
        uf[f] = ret;
        return ret;
    }

    static void union(int src, int dest) {
        int aRoot = find(src);
        int bRoot = find(dest);
        if (aRoot == bRoot)
            return ;
        uf[aRoot] = bRoot;
        // System.out.format("aRoot(%d) cnt : %d bRoot(%d) cnt : %d\n", aRoot, cnt[aRoot], bRoot, cnt[bRoot]);
        cnt[bRoot] += cnt[aRoot];
        // System.out.format("bRoot(%d) cnt : %d\n", bRoot, cnt[bRoot]);
    }
}