import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        // Please write your code here.
        int[] cArr = new int[n];
        int[] wArr = new int[n];
        if (str.charAt(0) == 'C') {
            cArr[0] = 1;
        }
        if (str.charAt(n-1) == 'W') {
            wArr[n-1] = 1;
        }

        for(int i = 1; i < n; i++) {
            cArr[i] = cArr[i-1];
            if (str.charAt(i) == 'C') {
                cArr[i] += 1;
            }
        }

        for(int i = n-2; i >= 0; i--) {
            wArr[i] = wArr[i+1];
            if (str.charAt(i) == 'W') {
                wArr[i] += 1;
            }
        }

        int ans = 0;
        for(int i = 1; i < n-1; i++) {
            if (str.charAt(i) != 'O')
                continue;
            ans += cArr[i-1] * wArr[i+1];
        }

        System.out.println(ans);
    }
}
// 'O'를 찾아서 좌 우에 C와 W의 갯수를 곱해서 더하면 됨