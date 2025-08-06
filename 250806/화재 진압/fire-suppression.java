import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] fires = new int[n];
        int[] stations = new int[m];
        for (int i = 0; i < n; i++)
            fires[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            stations[i] = sc.nextInt();
        

        Arrays.sort(fires);
        Arrays.sort(stations);
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        // stations 인덱스
        int j = 0;
        int max = Integer.MIN_VALUE;
        // 현재 station
        int cur = stations[j];
        for(int i = 0; i < n; i++) {
            while(j < m && Math.abs(cur - fires[i]) < ans[i]) {
                ans[i] = Math.abs(cur - fires[i]);
                if (j < m-1) {
                    j++;
                    cur = stations[j];
                }
            }
        }

        for(int i = 0 ; i < n; i++) {
            max = Math.max(max, ans[i]);            
        }

        System.out.println(max);
    }
}