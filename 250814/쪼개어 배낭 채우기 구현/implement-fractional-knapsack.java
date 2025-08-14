import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Gem[] arr = new Gem[n];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            arr[i] = new Gem(w,v);
        }
        Arrays.sort(arr, (g1, g2) -> {
            if (g1.t < g2.t) {
                return 1;
            } else if (g1.t > g2.t) {
                return -1;
            }
            return 0;
        });
        double sum = 0;
        int mount = 0;
        int idx = 0;
        while(mount != m && idx < n) {
            Gem cur = arr[idx];
            idx++;
            int curW = Math.min(m - mount, cur.w);
            sum += cur.t * curW;
            mount += curW;
        }
        System.out.format("%.3f\n", sum);
    }

    public static class Gem {
        int w;
        int v;
        double t;
        
        public Gem(int w, int v) {
            this.w = w;
            this.v = v;
            this.t = (double)v/(double)w;
        }
    }
}