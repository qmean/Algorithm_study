import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        TreeSet<Point> xSet = new TreeSet<>((p1, p2) -> {
            return p1.x - p2.x;
        });
        TreeSet<Point> ySet = new TreeSet<>((p1, p2) -> {
            return p1.y - p2.y;
        });

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point p = new Point(x,y);
            xSet.add(p);
            ySet.add(p);
        }

        int idx = 0;
        for (Point p : xSet) {
            p.xIdx = idx;
            idx++;
        }

        idx = 0;
        for (Point p : ySet) {
            p.yIdx = idx;
            idx++;
        }


        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            Point minX = new Point(Math.min(x1, x2), 0);
            Point maxX = new Point(Math.max(x1, x2), 0);
            Point minY = new Point(0, Math.min(y1, y2));
            Point maxY = new Point(0, Math.max(y1, y2));

            // 조건에 해당하는 개수 찾기
            if (xSet.ceiling(minX) == null || xSet.floor(maxX) == null || ySet.ceiling(minY) == null || ySet.floor(maxY) == null) {
                System.out.println(0);
                continue;
            }
            int xNum = xSet.floor(maxX).xIdx - xSet.ceiling(minX).xIdx + 1;
            int yNum = ySet.floor(maxY).yIdx - ySet.ceiling(minY).yIdx + 1;
            System.out.println(Math.min(xNum, yNum));
        }
        // Please write your code here.   
    }

    public static class Point {
        int x;
        int y;
        int xIdx;
        int yIdx;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

// x y
// Point 객체 만들어서 비교
// x 기준 정렬
// y 기준 정렬
// SortedSet에서 ceiling과 floor 둘다 보기
// 두개에 해당되는 점만 출력

// x1 <= x <= x2 && y1 <= y <= y2 인지를 판단해야 함

// qlogq안에 해결해야 하는데 그럼 각각의 케이스에 대해 logq 안에 해결해야 한다
/**
TreeMap을 이용?
<좌표, 인덱스>로 해야 할텐데 그러면
*/

