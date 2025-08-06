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
        for(int i = 0; i < n; i++) {
            while(j < m && stations[j] < fires[i]) {
                if (j == m-1)
                    break;
                j++;
            }
            ans[i] = Math.abs(stations[j] - fires[i]);
        }
        j = m-1;
        for(int i = n-1; i >= 0; i--) {
            while(j >= 0 && stations[j] > fires[i]) {
                if (j == 0)
                    break;
                j--;
            }
            ans[i] = Math.min(Math.abs(stations[j] - fires[i]), ans[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, ans[i]);
        }

        System.out.println(max);
    }
}