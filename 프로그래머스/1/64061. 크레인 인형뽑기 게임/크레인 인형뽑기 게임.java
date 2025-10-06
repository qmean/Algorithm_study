import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = board[0].length;
        int cnt = 0;
        // print(board);
        for (int ptr : moves) {
            int target = -1;
            int value = -1;
            for (int i = 0; i < n; i++) {
                if (board[i][ptr-1] != 0) {
                    target = i;
                    value = board[i][ptr-1];
                    board[i][ptr-1] = 0;
                    break;
                }
            }
            if (target == -1)
                continue;
            if (stack.peekLast() != null && stack.peekLast() == value) {
                stack.pollLast();
                cnt += 2;
            } else {
                stack.add(value);
            }
            // print(board);
            // System.out.println(stack);
            // System.out.println();
        }
        return cnt;
    }
    
    void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int k : arr[i]) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}