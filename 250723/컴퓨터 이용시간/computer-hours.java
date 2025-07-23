import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Time(start, +1, i));
            list.add(new Time(end, -1, i));
        }
        list.sort((t1, t2) -> {
            return t1.x - t2.x;
        });
        int[] ans = new int[n];
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            pq.add(i);
        }
        for(Time t : list) {
            if (t.v == 1) {
                ans[t.idx] = pq.poll();
            } else {
                pq.add(ans[t.idx]);
            }
        }

        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static class Time {
        int x;
        int v;
        int idx;

        public Time(int x, int v, int idx) {
            this.x = x;
            this.v = v;
            this.idx = idx;
        }
    }
}

/**
사람수 n
컴퓨터 이용시 자리 번호중 가장 작은 자리에 앉음
각각이 사용한 번호를 구하기
*/