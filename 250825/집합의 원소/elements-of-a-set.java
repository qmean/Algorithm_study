import java.util.Scanner;
public class Main {
    static int[] uf;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        uf = new int[n+1];
        for(int i = 1; i <= n; i++) {
            uf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int qType = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (qType == 0) {
                union(a,b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }

    static int find(int a) {
        if (uf[a] == a)
            return a;
        int root = find(uf[a]);
        uf[a] = root;
        return root;
    }

    static void union(int a, int b) {
        int aroot = find(a);
        int broot = find(b);
        if (aroot == broot)
            return;
        uf[aroot] = broot;
    }
}