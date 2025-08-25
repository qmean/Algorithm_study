import java.util.*;
public class Main {

    static int[] uf;
    static Set<Integer> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] edges = new int[n - 2][2];
        set = new HashSet<>();
        uf = new int[n+1];
        for(int i = 1; i <= n; i++) {
            uf[i] = i;
            // set.add(i);
        }
        for (int i = 0; i < n - 2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a,b);
        }
        for(int i = 1; i <= n; i++) {
            set.add(find(i));
        }
        set.stream().sorted(Comparator.naturalOrder()).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    static int find(int d) {
        if (uf[d] == d)
            return d;
        uf[d] = find(uf[d]);
        return uf[d];
    }

    static void union(int a, int b) {
        int ar = find(a);
        int br = find(b);
        if (ar < br) {
            uf[br] = ar;
            // set.remove(br);
        } else if (a > b) {
            uf[ar] = br;
            // set.remove(ar);
        }
    }
}