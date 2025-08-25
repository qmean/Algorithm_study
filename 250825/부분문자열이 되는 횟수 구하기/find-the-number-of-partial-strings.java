import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int n = A.length();
        int[] del = new int[n];
        for (int i = 0; i < n; i++) {
            del[i] = sc.nextInt();
        }
        // Please write your code here.
        int start = 0;
        int end = n;

        int max = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            int bIdx = 0;
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < mid; i++) {
                set.add(del[i]);
            }
            for(int i = 0; i < n; i++) {
                if (set.contains(i+1)) {
                    continue;
                }
                if (A.charAt(i) == B.charAt(bIdx)) {
                    bIdx++;
                    if (bIdx == B.length())
                        break;
                }
            }

            if (bIdx == B.length()) {
                start = mid + 1;
                max = Math.max(max, mid + 1);
            } else {
                end = mid - 1;
            }
        }
        System.out.println(max);
    }
}

/*
특정 시점 기준으로 부분 문자열이 안되게 하는 조건 구하기

앞에서 쭉 가면서 뺀거 제외하고 n번 확인
*/