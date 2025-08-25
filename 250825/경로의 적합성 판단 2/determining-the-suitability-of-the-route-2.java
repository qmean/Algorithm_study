import java.util.Scanner;
public class Main {

    static int[] uf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        uf = new int[n+1];
        for (int i = 1; i <= n; i++)
            uf[i] = i;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }
        int[] path = new int[k];
        for (int i = 0; i < k; i++) {
            path[i] = sc.nextInt();
        }
        int cur = path[0];
        for (int i = 1; i < k; i++) {
            if (find(cur) == find(path[i])) {
                cur = path[i];
            } else {
                System.out.println(0);
                return ;
            }
        }
        System.out.println(1);
    }

    static int find(int f) {
        if (uf[f] == f)
            return f;
        int root = find(uf[f]);
        uf[f] = root;
        return root;
    }

    static void union(int src, int dest) {
        int aRoot = find(src);
        int bRoot = find(dest);
        
        uf[aRoot] = bRoot;
    }
}