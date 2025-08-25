import java.util.*;

public class Main {

    static int[] uf;
    static int[] size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        uf = new int[n+1];
        size = new int[n+1];
        for (int i = 1; i <= n; i++) {
            uf[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(x, y);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();

        int br = find(b);
        int ar = find(a);
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int root = find(i);
            if (root != br && root != ar)
                set.add(root);
        }
        List<Integer> list = new ArrayList<>();
        for(int i : set) {
            list.add(size[i]);
        }
        list.sort(Comparator.reverseOrder());
        int cnt = 0;
        for(int i = 0; i < k; i++) {
            if (i == list.size())
                break;
            cnt += list.get(i);
        }
        System.out.println(cnt + size[ar]);
    }

    static int find(int f) {
        if (uf[f] == f)
            return f;
        uf[f] = find(uf[f]);
        return uf[f];
    }

    static void union(int src, int dest) {
        int sr = find(src);
        int dr = find(dest);
        if (sr == dr)
            return ;
        uf[sr] = dr;
        size[dr] += size[sr];
    }
}