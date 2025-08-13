import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Segment[] arr = new Segment[n];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            Segment s = Segment.of(x1, x2);
            arr[i] = s;
        }
        Arrays.sort(arr, (s1, s2) -> s1.start - s2.start);

        int start = 0;
        int end = (int)10e9;
        int max = Integer.MIN_VALUE;
        while(start <= end) {
            int mid = (start + end) / 2;
            boolean ok = true;
            int before = arr[0].start;
            for(int i = 1; i < n; i++) {
                if (before + mid > arr[i].end) {
                    ok = false;
                    break;
                }
                before = Math.max(before + mid, arr[i].start);
            }
            if (ok) {
                max = Math.max(max, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(max);   
    }

    public static class Segment {
        int start;
        int end;
        
        public static Segment of(int st, int e) {
            Segment s = new Segment();
            s.start = st;
            s.end = e;
            return s;
        }
    }
}