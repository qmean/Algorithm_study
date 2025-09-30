class Solution {
    
    final char EMPTY = '&';
    char[][] map;
    int n;
    int m;
    
    public int solution(int m, int n, String[] board) {
        this.n = n;
        this.m = m;
        map = new char[n][m];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        
        int answer = 0;
        while (true) {
            // print();
            int add = delete();
            if (add == 0)
                break;
            // print();
            answer += add;
            // print();
            trim();
        }
        
        return answer;
    }
    
    public void trim() {
        while (true) {
        int change = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i+1][j] == EMPTY && map[i][j] != EMPTY) {
                    map[i+1][j] = map[i][j];
                    map[i][j] = EMPTY;
                    change++;
                }
            }
        }
            if (change == 0)
                break;
        }
    }
    
    public int delete() {
        boolean[][] delete = new boolean[n][m];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                boolean flag = true;
                char cur = map[i][j];
                for (int a = 0; a < 2; a++) {
                    for (int b = 0; b < 2; b++) {
                        if (map[i+a][j+b] != cur || map[i+a][j+b] == EMPTY)
                            flag = false;
                    }
                }
                if (flag) {
                    for (int a = 0; a < 2; a++) {
                        for (int b = 0; b < 2; b++) {
                            delete[i+a][j+b] = true;
                        }
                    }        
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (delete[i][j]) {
                    cnt++;
                    map[i][j] = EMPTY;
                }
            }
        }
        return cnt;
    }
    
    void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}