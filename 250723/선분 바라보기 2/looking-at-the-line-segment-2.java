import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int y = sc.nextInt();
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            list.add(Point.of(x1, y, 1, i));
            list.add(Point.of(x2, y, -1, i));
        }
        
        list.sort((p1, p2) -> p1.x - p2.x);

        // 현재 보고있는 y값 좌표
        int vy = Integer.MAX_VALUE;
        // 현재 있는 선분들 (y값, idx)
        TreeMap<Integer, Integer> yIdxMap = new TreeMap<>();
        // 현재 있는 선분들 (idx, y값)
        TreeMap<Integer, Integer> idxYMap = new TreeMap<>();
        // 관측할 수 있는 idx 저장
        Set<Integer> set = new HashSet<>();
        for(Point p : list) {
            if (p.v == 1) {
                if (p.y < vy) {
                    set.add(p.idx);
                    vy = p.y;
                }
                yIdxMap.put(p.y, p.idx);
                idxYMap.put(p.idx, p.y);
            } else {
                yIdxMap.remove(p.y);
                idxYMap.remove(p.idx);
                if (yIdxMap.isEmpty()) {
                    vy = Integer.MAX_VALUE;
                    continue ;
                }
                vy = yIdxMap.firstKey();
                set.add(yIdxMap.get(vy));
            }
        }
        System.out.println(set.size());
    }
    
    public static class Point {
        int x;
        int y;
        int v;
        int idx;

        public static Point of(int x, int y, int v, int idx) {
            Point p = new Point();
            p.x = x;
            p.y = y;
            p.v = v;
            p.idx = idx;
            return p;
        }
    }
}