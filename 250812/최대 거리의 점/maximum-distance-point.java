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
        int ans = Integer.MIN_VALUE;
        while (start <= end) {
            // System.out.println("start " + start + " end " + end);
            int dist = (start + end) / 2;
            int cnt = 1;
            Integer cur = points[0];
            int curMin = Integer.MAX_VALUE;
            // System.out.println(dist + "=======");
            while (cur != null) {
                Integer ni = set.ceiling(cur + dist);
                // System.out.println(cur + " " + ni + " " +curMin);
                if (ni != null) {
                    curMin = Math.min(curMin, ni - cur);
                    cnt++;
                }
                cur = ni;
            }
            // System.out.println("cnt == "+ cnt);
            if (cnt >= m) {
                ans = Math.max(ans, curMin);
                start = dist + 1;
            } else {
                end = dist - 1;
            }
            // System.out.println("new======== start " + start + " end " + end);
        }
        System.out.println(ans);
    }
}