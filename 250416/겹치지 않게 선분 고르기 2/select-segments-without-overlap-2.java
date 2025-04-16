import java.util.*;
public class Main {
    public static int[] dp;
    public static int n;
    public static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[1001];
        int[][] segments = new int[n][2];
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            list.add(Pair.of(first, second));

            // end.put(end, start);
            segments[i][0] = first;
            segments[i][1] = second;
        }
        list.sort((p1, p2) -> p1.start - p2.start);
        Arrays.fill(dp, Integer.MIN_VALUE);
        for(int i = 0; i < list.size(); i++) {
            Pair p1 = list.get(i);
            if (dp[p1.start] < 0)
                dp[p1.start] = 1;
            for(int j = 0; j < i; j++) {
                Pair p2 = list.get(j);
                if (p2.end < p1.start) {
                    dp[p1.start] = Math.max(dp[p1.start], dp[p2.start] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= 1000; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    public static class Pair {
        int start;
        int end;

        public static Pair of(int start, int end) {
            Pair p = new Pair();
            p.start = start;
            p.end = end;
            return p;
        }
    }
}