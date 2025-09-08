import java.util.*;
public class Main {

    static int[] uf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] map = new ArrayList[n];
        
        final int TEAM_A = n;
        final int TEAM_B = n+1;
        uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
            map[i] = new ArrayList<>();
        }
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;

            map[a].add(b);
            map[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> list = map[i];
            if (!flag)
                break;
            for (int j = 0; j < list.size() - 1; j++) {
                if (!union(list.get(j), list.get(j+1))) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag ? 1 : 0);
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