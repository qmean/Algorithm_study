import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] points = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
            set.add(points[i]);
            max = Math.max(max, points[i]);
            min = Math.min(min, points[i]);
        }
        
        int start = 0;
        int end = max - min;
        int ans = 0;
        while (start <= end) {
            // System.out.println("start " + start + " end " + end);
            int dist = (start + end) / 2;
            int cnt = 0;
            int idx = 0;
            // int curMin = Integer.MAX_VALUE;
            // System.out.println(dist + "=======");
            for(int i = 1; i < n; i++) {
                if (points[i] - points[idx] >= dist) {
                    cnt++;
                    idx = i;
                }
            }
            // System.out.println("cnt == "+ cnt);
            if (cnt >= m) {
                ans = Math.max(ans, dist);
                start = dist + 1;
            } else {
                end = dist - 1;
            }
        }
        System.out.println(ans);
    }
}