import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        Map<Integer, Integer> outMap = new HashMap<>();
        Map<Integer, Integer> inMap = new HashMap<>();
        Set<Integer> outSet = new HashSet<>();
        Set<Integer> inSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            if (0 < arr[i] && arr[i] <= m) {
                outMap.put(arr[i], outMap.getOrDefault(arr[i], 0) + 1);
                outSet.add(arr[i]);
                inMap.put(arr[i], 0);
            }
        }
        
        int j = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            while(j + 1 < n && inSet.size() < m) {
                if (1 <= arr[j+1] && arr[j+1] <= m) {
                    inMap.put(arr[j+1], inMap.get(arr[j+1]) + 1);
                    inSet.add(arr[j+1]);
                    outMap.put(arr[j+1], outMap.get(arr[j+1]) - 1);
                    if (outMap.get(arr[j+1]) == 0) {
                        outSet.remove(arr[j+1]);
                    }
                }
                j++;
            }

            if (inSet.size() == m && outSet.size() == m) {
                min = Math.min(min, j - i + 1);
            }
            
            // System.out.format("=====i : %d j : %d =====\n", i, j);
            // System.out.println("inMap\n" + inMap);
            // System.out.println("outMap\n" + outMap);
            outMap.put(arr[i], outMap.get(arr[i]) + 1);
            outSet.add(arr[i]);
            inMap.put(arr[i], inMap.get(arr[i])- 1);
            if (inMap.get(arr[i]) == 0) {
                inSet.remove(arr[i]);
            }
        }
        if (min != Integer.MAX_VALUE)
            System.out.println(min);
        else
            System.out.println(-1);
    }
}