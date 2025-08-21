import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        // T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            br.readLine();
            boolean[][] map = new boolean[100][100];
            boolean[][] visited = new boolean[100][100];
            int[] dx = { 0, 0, 1, -1 };
            int[] dy = { 1, -1, 0, 0 };

            int destx = 0;
            int desty = 0;
            int srcx = 0;
            int srcy = 0;

            for (int i = 0; i < 100; i++) {
                String s = br.readLine();
                for (int j = 0; j < 100; j++) {
                    char c = s.charAt(j);
                    if (c == '1') {
                        map[i][j] = false;
                        continue;
                    } else if (c == '2') {
                        srcx = i;
                        srcy = j;
                    } else if (c == '3') {
                        destx = i;
                        desty = j;
                    }
                    map[i][j] = true;
                }
            }

            Queue<Point> q = new ArrayDeque<>();
            q.add(new Point(srcx, srcy));
            visited[srcx][srcy] = true;
            while (!q.isEmpty()) {
                Point cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && map[nx][ny] &&!visited[nx][ny]) {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }

            System.out.println("#" + test_case + " " + (visited[destx][desty] ? 1 : 0));
        }
    }
}
