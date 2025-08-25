import java.util.*;

public class Main {

    static int[] uf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        Segment[] arr = new Segment[m];
        uf = new int[n+1];
        for (int i = 1; i <= n; i++) {
            uf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a1 = sc.nextInt();
            int b1 = sc.nextInt();
            int v = sc.nextInt();
            arr[i] = new Segment(a1, b1, v);
        }
        Arrays.sort(arr, (s1, s2) -> {
            return s2.v - s1.v;
        });

        for(int i = 0; i < m; i++) {
            Segment cur = arr[i];
            union(cur.a, cur.b);
            if (find(a) == find(b)) {
                System.out.println(cur.v);
                return ;
            }
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
        uf[ar] = br;
    }

    static class Segment {
        int a;
        int b;
        int v;
        public Segment(int a, int b, int v) {
            this.a = a;
            this.b = b;
            this.v = v;
        }
    }
}