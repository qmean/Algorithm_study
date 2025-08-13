import java.util.*;
public class Main {
    static boolean[][] visited;
    static int[][] board;
    static int[][] colored;
    static int n,m;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();
        colored = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                colored[i][j] = sc.nextInt();
        int start = 0;
        int end = (int)10e9;
        int min = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end) / 2;
            int max = Integer.MIN_VALUE;
            int coloredCnt = 0;
            for(int i = 0; i < m; i++)
                Arrays.fill(visited[i], false);
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if (!visited[i][j])
                        coloredCnt += dfs(i, j, mid) ? 1 :0;
                }
            }
            if (coloredCnt <= 1) {
                min = Math.min(min, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(min);
    }

    public static boolean dfs(int x, int y, int d) {
        visited[x][y] = true;
        boolean ret = colored[x][y] == 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;
            if (visited[nx][ny])
                continue;
            if (Math.abs(board[x][y] - board[nx][ny]) > d) {
                continue;
            }
            ret = dfs(nx, ny, d) == true ? true : ret;
        }
        return ret;
    }
}