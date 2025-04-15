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
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            if (map.containsKey(second))
                map.get(second).add(first);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(first);
                map.put(second, list);
            }

            // end.put(end, start);
            segments[i][0] = first;
            segments[i][1] = second;
        }
        // Please write your code here.
        dp[0] = 0;
        // int max = 1;
        System.out.println(find(1000));
        // for(int i = 1; i <= 100; i++) {
        //     System.out.println(dp[i]);
        // }
    }

    public static int find(int cur){
        if (dp[cur] > 0) {
            return dp[cur];
        }
        List<Integer> list = map.get(cur);
        if (list != null) {
            for(Integer i : list) {
                dp[cur] = Math.max(find(i-1) + 1, dp[cur]);
            }
        }
        for (int i = 1; i < cur; i++) {
            dp[cur] = Math.max(dp[cur], find(i));
        }
        return dp[cur];
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