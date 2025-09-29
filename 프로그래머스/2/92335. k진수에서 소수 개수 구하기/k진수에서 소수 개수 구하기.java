import java.util.*;

class Solution {
    
    Set<Long> set = new HashSet<>();
    
    public int solution(int n, int k) {
        String s = Integer.toString(n, k);
        System.out.println(s);
        String[] arr = s.split("0");
        return (int)Arrays.stream(arr)
            .filter(str -> !str.isEmpty())
            .map(str -> Long.parseLong(str))
            .filter(num -> num != 1)
            .filter(num -> isPrime(num))
            .count();
    }
    
    public boolean isPrime(long num) {
        long idx = 2;
        while(idx <= Math.sqrt(num)) {
            if (num % idx == 0)
                return false;
            idx += 1;
        }
        return true;
    }
}