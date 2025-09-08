import java.util.*;

public class Main {

    static int[] uf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] cost = new int[n];
        uf = new int[n];
        PriorityQueue<Segment> pq = new PriorityQueue<>((s1, s2) -> s1.cost - s2.cost);
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
            uf[i] = i;
            pq.add(new Segment(i, cost[i]));
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt() - 1;
            int d = sc.nextInt() - 1;
            union(s,d);
        }

        int sum = 0;
        while (pq.size() >= 2) {
            Segment s1 = pq.poll();
            Segment s2 = pq.poll();
            if (union(s1.idx, s2.idx)) {
                sum += s1.cost + s2.cost;
                if (s1.cost < s2.cost) {
                    pq.add(new Segment(s1.idx, s1.cost));
                } else {
                    pq.add(new Segment(s2.idx, s2.cost));
                }
            }
        }
        // System.out.println(sum);
        System.out.println(sum > k ? "NO" : sum);
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
        uf[Math.max(ar, br)] = Math.min(ar, br);
        return true;
    }

    static class Segment {
        int idx;
        int cost;

        public Segment(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}