import java.util.*;

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

        int cnt = 0;
        while(m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if (find(a) == find(b))
                cnt++;
            else
                union(a,b);
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            set.add(find(i));
        }

        cnt += set.size() - 1;
        System.out.println(cnt);
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
}