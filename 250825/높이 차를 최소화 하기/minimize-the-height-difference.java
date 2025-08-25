import java.util.*;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0 ,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int left = 0;
        int right = 500;
        int min = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = (left + right) / 2;
            for(int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }
            dfs(0,0,board[0][0],mid);
            if (visited[n-1][m-1]) {
                right = mid - 1;
                min = Math.min(min, mid);
            } else {
                left = mid + 1;
            }
        }        
        System.out.println(min);
    }

    public static void dfs(int x, int y, int min, int cond) {
        if (x == n-1 && y == m-1) {
            visited[x][y] = true;
            return;
        }
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] - min <= cond && !visited[nx][ny]) {
                dfs(nx, ny, Math.min(min, board[nx][ny]), cond);
            }
        }
    }
}