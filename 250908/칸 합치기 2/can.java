import java.util.Scanner;
public class Main {

    static int[] uf;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        uf = new int[n];
        for (int i = 0; i < n; i++)
            uf[i] = i;

        int cnt = n;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            
            int cur = a;
            int end = b;
            while (true) {
                int next = find(cur) + 1;
                if (next > end) {
                    break;
                }
                union(cur, next);
                cnt--;
                cur = find(cur);
            }
            System.out.println(cnt);
        }
    }

    static int find(int f) {
        if (uf[f] == f)
            return f;
        uf[f] = find(uf[f]);
        return uf[f];
    }

    static boolean union(int a, int b) {
        int ar = find(a);
        int br = find(b);

        if (ar == br)
            return false;
        if (ar > br)
            uf[br] = ar;
        else
            uf[ar] = br;
        return true;
    }
}