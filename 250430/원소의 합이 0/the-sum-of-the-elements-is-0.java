import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        Map<Integer, Integer> ab = new HashMap<>();
        Map<Integer, Integer> cd = new HashMap<>();
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int b = sc.nextInt();
            for(int j = 0; j < n; j++) {
                int a = A[j];
                ab.put(a+b, ab.getOrDefault(a+b, 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            C[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            for(int j = 0; j < n; j++) {
                int c = C[j];
                cd.put(c+d, cd.getOrDefault(c+d, 0) + 1);
            }
        }
        // Please write your code here.
        
        Set<Map.Entry<Integer, Integer>> abSet = ab.entrySet();
        long ans = 0L;
        for(Map.Entry<Integer, Integer> e : abSet) {
            int find = -1 * e.getKey();
            ans += e.getValue() * cd.getOrDefault(find, 0);
        }

        System.out.println(ans);
    }
}