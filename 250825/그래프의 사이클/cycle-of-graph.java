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
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (find(a) == find(b)) {
                System.out.println(i+1);
                return ;
            }
            union(a,b);
        }
        System.out.println("happy");
    }
    
    static int find(int d) {
        if (uf[d] == d)
            return d;
        uf[d] = find(uf[d]);
        return uf[d];
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        uf[aRoot] = bRoot;
    }
}