import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        PriorityQueue<Stage> pq = new PriorityQueue<>((s1, s2) -> {
           if (s1.v == s2.v)
               return s1.idx - s2.idx;
            else if (s1.v > s2.v) {
                return -1;
            } else {
                return 1;
            }
        });
        double sum = 0;
        int start = stages.length - 1;
        System.out.println();
        for (int i = N + 1; i > 0; i--) {
            double cnt = 0;
            while(start >= 0  && stages[start] == i) {
                start--;
                sum++;
                cnt++;
            }
            if (i == N+1)
                continue;
            if (sum == 0) {
                pq.add(new Stage(i, 0));
            } else {
                pq.add(new Stage(i, cnt / sum));
            }
        }
        int idx = 0;
        int[] answer = new int[N];
        while(!pq.isEmpty()) {
            answer[idx] = pq.poll().idx;
            idx++;
        }
        return answer;
    }
    
    public class Stage {
        int idx;
        double v;
        public Stage(int idx, double v) {
            this.idx = idx;
            this.v = v;
        }
    }
}