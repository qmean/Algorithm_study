import java.util.*;

public class Main {
    public static class Segment {
        int s;
        int e;
        public Segment(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Segment[] arr = new Segment[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[i] = new Segment(s, e);
        }
        Arrays.sort(arr, (s1, s2) -> s1.e - s2.e);
        int curEnd = arr[0].e;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (curEnd == arr[i].e || curEnd > arr[i].s) {
                continue;
            }
            cnt++;
            curEnd = arr[i].e;
        }        
        System.out.println(cnt);
    }
}