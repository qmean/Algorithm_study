import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 삭제되었을 경우 수직선상에서 없어지는 총 길이
        int[] delValue = new int[n];
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            list.add(new Point(x1, 1, i));
            list.add(new Point(x2, -1, i));
        }
        list.sort((p1, p2) -> {
            if (p1.x == p2.x) {
                return p2.v - p1.v;
            } else {
                return p1.x - p2.x;
            }
        });

        int sum = 0;
        int sumStart = 0;
        int idxStart = 0;
        int curIdx = 0;
        Set<Integer> set = new HashSet<>();
        
        for(Point p : list) {
            if (p.v == 1) {

                // 0 -> 1 (시작점)
                if (set.isEmpty()) {
                    sumStart = p.x;
                    idxStart = p.x;
                    curIdx = p.idx;
                }
                // 1 -> 2 (계산)
                else if (set.size() == 1) {
                    delValue[curIdx] += p.x - idxStart;
                    // System.out.format("curIdx = %d idxStart = %d currentX = %d\n", curIdx, idxStart, p.x);
                }
                set.add(p.idx);
            } 
            else {
                set.remove(p.idx);
                // 1-> 0 (계산)
                if (set.isEmpty()) {
                    sum += p.x - sumStart;
                    delValue[curIdx] += p.x - idxStart;
                    // System.out.format("curIdx = %d idxStart = %d currentX = %d\n", curIdx, idxStart, p.x);
                } 
                // 2 -> 1 (시작점)
                else if (set.size() == 1) {
                    // delValue[curIdx] += p.x - idxStart;
                    curIdx = set.iterator().next();
                    idxStart = p.x;
                }
            }
            // System.out.format("p.x : %d p.v : %d p.idx = %d idxStart = %d curIdx = %d\n", p.x, p.v, p.idx, idxStart, curIdx);
        }

        int min = Integer.MAX_VALUE;
        // System.out.println("=====");
        for(int i : delValue) {
            // System.out.println(i);
            min = Math.min(i, min);
        }
        System.out.println(sum - min);
    }

    public static class Point {
        int idx;
        int x;
        int v;
        public Point(int x, int v, int idx) {
            this.x = x;
            this.v = v;
            this.idx = idx;
        }
    }
}

/**
set의 원소 수에 따라 다르게 작동
0 -> 1 (시작점)
1 -> 0 (종료) => 계산해야함
1 -> 2 (종료) => 계산해야함
2 -> 1 (시작점)
*/