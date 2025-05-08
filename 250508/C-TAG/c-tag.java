import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] groupA = new String[n];
        String[] groupB = new String[n];
        for (int i = 0; i < n; i++) {
            groupA[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            groupB[i] = sc.next();
        }
        // Please write your code here.

        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        int cnt = 0;
        for(int i = 0; i < m-2; i++) {
            for(int j = i+1; j < m-1; j++) {
                for(int k = j+1; k < m; k++) {
                    setA.clear();
                    setB.clear();
                    for(int a = 0; a < n; a++) {
                        setA.add(""+ groupA[a].charAt(i) + groupA[a].charAt(j) + groupA[a].charAt(k));
                        setB.add(""+ groupB[a].charAt(i) + groupB[a].charAt(j) + groupB[a].charAt(k));
                    }
                    boolean ans = true;
                    for(String aString : setA) {
                        if (setB.contains(aString)) 
                            ans = false;
                    }
                    if (ans)
                        cnt++;
                }
            }
        }

        // for(String s : setA) {
        //     System.out.println(s);
        // }

        System.out.println(cnt);
    }
}