import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        // Please write your code here.
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i < n; i++) {
            int cur = arr[i];
            for(int j = sum; j >= cur; j--) {
                if (dp[j - cur])
                    dp[j] = true;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= sum; i++) {
            if (!dp[i])
                continue;
            min = Math.min(min, Math.abs(sum - (i * 2)));
        }
        System.out.println(min);
    }
}

/*
cond)
주어진 수열을 두 개의 그룹으로 나누어야함
a에서 고른 것과 b에서 고른 것이 같으면 안됨
각 그룹은 1개 이상 가지고 있어야함
그룹 a와 b의 차이가 최솟값이 되도록 해야함

sol)
하나씩 고를수 있도록 dp 설정
dp[i] = 하나만 써서 i 를 만들 수 있는지 여부

dp[i] 를 돌면서 true 이면 a 와 b의 값 계산 (a 를 i 라 치고 |a - b| 를 통해 최솟값 갱신)
*/