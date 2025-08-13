import java.util.*;
public class Main {
    static int[][] board;
    static int n;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();
        int bound = (n * n / 2) + (n % 2 == 0 ? 0 : 1);
        int start = 0;
        int end = (int)10e6;
        int min = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end) / 2;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < n; k++)
                        Arrays.fill(visited[k], false);
                    max = Math.max(max, dfs(i, j, mid));
                }
            }
            
            if (max >= bound) {
                min = Math.min(min, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(min);
    }

    public static int dfs(int x, int y, int d) {
        visited[x][y] = true;
        int sum = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 > nx || nx >= n || 0 > ny || ny >= n)
                continue;
            if (visited[nx][ny])
                continue;    
            if (Math.abs(board[x][y] - board[nx][ny]) > d)
                continue;
            sum += dfs(nx, ny, d);
        }
        return sum;
    }
}