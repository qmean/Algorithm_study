import java.util.*;

public class Main {

    static ArrayList<Segment>[] edges;
    static long[] dp;
    static int[] time;
    static int[] cost;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt()-1;
        int end = sc.nextInt()-1;
        int N = sc.nextInt();

        edges = new ArrayList[1000];
        dp = new long[1000];
        time = new int[1000];
        cost = new int[N];

        for (int i = 0; i < 1000; i++) {
            edges[i] = new ArrayList<>();
        }
        Arrays.fill(dp, (long)1e13);
        Arrays.fill(time, (int)1e9);

        for (int i = 0; i < N; i++) {
            int c = sc.nextInt();
            int stopCount = sc.nextInt();
            cost[i] = c;
            int curStop = sc.nextInt()-1;
            for (int j = 1; j < stopCount; j++) {
                int stop = sc.nextInt()-1;
                edges[stop].add(new Segment(curStop, c, i));
                curStop = stop;
            }
        }

        dp[end] = 0;
        time[end] = 0;
        PriorityQueue<Segment> pq = new PriorityQueue<>((s1, s2) -> s1.cost - s2.cost);
        int minBus = -1;
        int minValue = Integer.MAX_VALUE;
        for (Segment edge : edges[end]) {
            if (minValue > edge.cost) {
                minBus = edge.busNum;
                minValue = edge.cost;
            }
        }
        dp[end] = 0;
        pq.add(new Segment(end, 0, -1));

        while(!pq.isEmpty()) {
            Segment cur = pq.poll();
            int curStop = cur.num;
            int curCost = cur.cost;
            int curBus = cur.busNum;

            if (dp[curStop] != curCost)
                continue;

            for (Segment edge : edges[curStop]) {
                int nextStop = edge.num;
                int nextBus = edge.busNum;
                int newCost = curBus != nextBus ? curCost + cost[nextBus] : curCost;
                
                if (dp[nextStop] > newCost) {
                    dp[nextStop] = newCost;
                    time[nextStop] = time[curStop] + 1;
                    pq.add(new Segment(nextStop, newCost, nextBus));
                } else if (dp[nextStop] == newCost && time[nextStop] > time[curStop] + 1) {
                    time[nextStop] = Math.min(time[nextStop], time[curStop] + 1);
                    pq.add(new Segment(nextStop, newCost, nextBus));
                }
            }
        }
        
        if (dp[start] == (long)1e13)
            System.out.println("-1 -1");
        else
            System.out.println(dp[start]+ " " + time[start]);
    }

    static class Segment {
        int num;
        int cost;
        int busNum;

        public Segment(int n, int c, int busNum) {
            num = n;
            cost = c;
            this.busNum = busNum;
        }
    }
}