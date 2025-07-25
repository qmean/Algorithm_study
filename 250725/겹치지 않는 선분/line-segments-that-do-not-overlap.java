import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        // start 기준 오름차순 정렬
        Queue<Point> startQ = new PriorityQueue<>((p1, p2) -> {
            return p1.start - p2.start;
        });
        // end 기준 내림차순 정렬
        Queue<Point> endQ = new PriorityQueue<>((p1, p2) -> {
            return p2.end - p1.end;
        });
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            int start = Math.min(x1,x2);
            int end = Math.max(x1,x2);
            set.add(i);
            Point p = new Point(start, end, i);
            startQ.add(p);
            endQ.add(p);
        }
        
        // end가 가장 큰거로 갱신
        Point p = startQ.poll();
        // System.out.format("P = %d %d %d\n", p.start, p.end, p.idx);
        while(!startQ.isEmpty()) {
            Point cur = startQ.poll();
            // System.out.format("cur = %d %d %d\n", cur.start, cur.end, cur.idx);
            if (cur.end > p.end) {
                // System.out.format("removed at cur = %d %d %d\n", cur.start, cur.end, cur.idx);
                // System.out.format("removed at p = %d %d %d\n", p.start, p.end, p.idx);
                // set.remove(cur.idx);
                // set.remove(p.idx);
                p = cur;
            } else {
                set.remove(cur.idx);
                set.remove(p.idx);
            }
        }

        // System.out.println("==================");
        // x1이 가장 작은거로 갱신
        p = endQ.poll();
        // System.out.format("P = %d %d %d\n", p.start, p.end, p.idx);
        while(!endQ.isEmpty()) {
            Point cur = endQ.poll();
            // System.out.format("cur = %d %d %d\n", cur.start, cur.end, cur.idx);
            if (cur.start < p.start) {
                // System.out.format("removed at cur = %d %d %d\n", cur.start, cur.end, cur.idx);
                // System.out.format("removed at p = %d %d %d\n", p.start, p.end, p.idx);
                // set.remove(cur.idx);
                // set.remove(p.idx);
                p = cur;
            } else {
                set.remove(cur.idx);
                set.remove(p.idx);
            }
        }

        System.out.println(set.size());
    }

    public static class Point {
        final int start;
        final int end;
        final int idx;

        public Point(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }
}

/* p1(x1, x2)와 p2(x1, x2)가 있다고 하면
==> x1과 x2들은 절대 겹치지 않음
p1.x1 < p2.x2 인 경우

1 p1.x2 < p2.x2
만나지 않음
2 p1.x2 > p2.x2
만난다

con)
p3에 대해 검사한다고 할 때, pk.x1 < p3.x1 < p3.x2 < pk.x2 인 pk가 존재함을 검사해야 한다
그리고 이 pk가 존재할 때 선분이 만난다면 더 큰걸로 덮어씌워도 된다

sol1)

LR Technique 사용하려면?

왼쪽에서 가장 가까운거 조회 (pl)
오른쪽에서 가장 가까운거 조회 (pr)

==> 안됨

sol2)

x1기준 오름차순으로 순환
-> 내 왼쪽꺼 중에서 가장 큰 x2를 가진것과 비교
-> 내가 더 크면 그거로 갱신

x2 기준 내림차순으로 순환
반대로 수행

먼저 Set에 각 선분의 교유번호(인덱스) 전부 저장
만날 때마다 인덱스 삭제
set의 크기 출력 => 답

*/