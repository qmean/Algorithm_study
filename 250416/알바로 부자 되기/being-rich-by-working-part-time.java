import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        // Please write your code here.
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int iStart = s[i];
            int iEnd = e[i];
            int iPay = p[i];
            map.put(iEnd, Math.max(map.getOrDefault(iEnd, -1), p[i]));
            for(int j = 0; j < i; j++) {
                int jEnd = e[j];
                int jStart = s[j];
                if (jEnd < iStart) {
                    map.put(iEnd, Math.max(map.get(iEnd), map.get(jEnd) + iPay));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for(Map.Entry<Integer, Integer> entry : set) {
            max = Math.max(entry.getValue(), max);
        }

        // for(int i = 1; i <= 100; i++) {
        //     System.out.println(dp[i]);
        // }
        System.out.println(max);
    }
}