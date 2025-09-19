import java.util.Scanner;
public class Main {

    static int[] cnt;
    static int[] left;
    static int[] right;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        left = new int[n + 1];
        right = new int[n + 1];
        cnt = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            left[i] = sc.nextInt();
            right[i] = sc.nextInt();
        }
        long k = sc.nextLong();
        
        // build(1);

        for (long i = 0L; i < k-1; i++) {
            fill(1);
        }
        System.out.println(fill(1));

        
    }

    static int fill(int idx) {
        int l = left[idx];
        int r = right[idx];
        if (l == -1 && r == -1) {
            cnt[idx]++;
            return idx;
        }

        cnt[idx]++;
        if (l == -1) {    
            return fill(r);
        } else if (r == -1) {
            return fill(l);
        } else {
            if (cnt[l] <= cnt[r]) {
                return fill(l);
            } else {
                return fill(r);
            }
        }
    }

    static int build(int idx) {
        if (idx == -1)
            return 0;

        int sum = 1;
        sum += build(left[idx]);
        sum += build(right[idx]);

        cnt[idx] = sum;

        return sum;
    }
}