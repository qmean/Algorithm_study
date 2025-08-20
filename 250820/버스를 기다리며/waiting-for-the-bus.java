import java.util.*;
public class Main {
    public static int[] t;
    public static int n;
    public static int m;
    public static int c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        Arrays.sort(t);
        int left = 0;
        int right = (int)10e9;
        int ans = Integer.MAX_VALUE;
        while(left <= right) {
            int time = (left + right) / 2;
            if (valid(time)) {
                ans = Math.min(ans, time);
                right = time - 1;
            } else {
                left = time + 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean valid(int maxTime) {
        int busCount = 1;
        int busTime = t[0];
        int busPeople = 1;
        for(int i = 1; i < n; i++) {
            if (t[i] - busTime > maxTime || busPeople == c) {
                busCount++;
                busTime = t[i];
                busPeople = 1;
            } else {
                busPeople++;
            }
        }

        if (busCount > m) {
            return false;
        }
        return true;
    }
}

/*
사람 n명, 버스 m대
각 버스는 최대 c명까지 탑승 가능
버스가 출발할 때까지 가장 오래 기다려야 하는 사람이 기다리는 시간의 최솟값
최솟값을 t로 한다면
모든 사람이 t 이하로 기다려야 하고, 모든 사람이 버스를 타야함
*/