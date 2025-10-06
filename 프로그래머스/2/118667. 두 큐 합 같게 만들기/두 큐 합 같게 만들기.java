import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1Sum = Arrays.stream(queue1).sum();
        long q2Sum = Arrays.stream(queue2).sum();
        Arrays.stream(queue1).forEach(i -> q1.add(i));
        Arrays.stream(queue2).forEach(i -> q2.add(i));
        int cnt = 0;
        while (q1Sum != q2Sum) {
            if (q1Sum < q2Sum) {
                int v = q2.poll();
                q1.add(v);
                q1Sum += v;
                q2Sum -= v;
            } else {
                int v = q1.poll();
                q2.add(v);
                q2Sum += v;
                q1Sum -= v;
            }
            cnt++;
            if (cnt > queue1.length * 4) {
                break;
            }
        }
        return (cnt > queue1.length * 4 ? -1 : cnt);
    }
}