import java.util.*;

public class Main {

    static int[] uf;
    static Segment[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        uf = new int[n+1];
        for (int i = 1; i <= n; i++)
            uf[i] = i;

        int m = sc.nextInt();
        arr = new Segment[m];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr[i] = new Segment(u, v, w);
        }

        Arrays.sort(arr, (s1, s2) -> s1.v - s2.v);
        
        int ans = 0;
        for (Segment s : arr) {
            if (union(s.x1, s.x2))
                ans += s.v;
        }

        System.out.println(ans);
    }

    static int find(int x) {
        if (uf[x] == x)
            return x;
        uf[x] = find(uf[x]);
        return uf[x];
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot)
            return false;
        uf[aRoot] = bRoot;
        return true;
    }

    static class Segment {
        int x1;
        int x2;
        int v;

        public Segment(int x1, int x2, int v) {
            this.x1 = x1;
            this.x2 = x2;
            this.v = v;
        }
    }
}