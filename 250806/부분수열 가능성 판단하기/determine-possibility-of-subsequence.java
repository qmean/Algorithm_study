import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[m];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        for (int i = 0; i < m; i++) B[i] = sc.nextInt();
        
        int[] L = new int[m];
        int[] R = new int[m];

        Arrays.fill(L, -1);
        Arrays.fill(R, -1);
        
        int j = 0;
        for (int i = 0; i < m; i++) {
            while(j < n && A[j] != B[i]) {
                j++;
            }
            if (j != n)
                L[i] = j;
        }
        j = n-1;
        for (int i = m-1; i >= 0; i--) {
            while(j >= 0 && A[j] != B[i]) {
                j--;
            }
            if (j != -1)
                R[i] = j;
        }

        int cnt = 0;
        cnt += R[1] != -1 ? 1 : 0;
        cnt += L[m-2] != -1 ? 1 : 0;
        for (int i = 1; i < m-1; i++) {
            if (L[i-1] != -1 && R[i+1] != -1 && L[i-1] < R[i+1])
                cnt++;
        }
        System.out.println(cnt);
    }
}

/*
수열 b의 요소 하나를 제거 -> b가 a의 부분수열

b의 원소가 a에 차례대로 존재하는 경우의수 찾기

4 1 9 10 5 7 4 10
9 4 10 5

슬라이딩 윈도우 사용

b에서 9 -> a에서 9까지 이동
b에서 4 -> a에서 4까지 이동


*/