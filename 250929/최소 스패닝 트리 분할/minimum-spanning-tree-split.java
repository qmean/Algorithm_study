import java.util.*;

public class Main {
    
    static int[] uf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        uf = new int[n];
        for (int i = 0; i < n; i++)
            uf[i] = i;
        int m = sc.nextInt();
        Queue<Edge> q = new PriorityQueue<>((e1, e2) -> e1.v - e2.v);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int v = sc.nextInt();
            q.add(new Edge(a, b, v));
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            Edge cur = q.poll();
            if (union(cur.a, cur.b)) {
                sum += cur.v;
                max = Math.max(max, cur.v);
            }
        }

        System.out.println(sum - max);
    }

    static int find(int f){
        if (uf[f] == f)
            return f;
        return uf[f] = find(uf[f]);
    }

    static boolean union(int a, int b) {
        int ar = find(a);
        int br = find(b);
        if (ar == br)
            return false;
        uf[ar] = br;
        return true;
    }

    static class Edge {
        int a;
        int b;
        int v;

        public Edge (int a, int b, int v) {
            this.a = a;
            this.b = b;
            this.v = v;
        }
    }
}