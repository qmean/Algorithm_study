import java.util.*;

class Solution {
    
    Map<String, Integer> map = Map.of(
        "zero", 0,
        "one", 1,
        "two", 2,
        "three", 3,
        "four", 4,
        "five", 5,
        "six", 6,
        "seven", 7,
        "eight", 8,
        "nine", 9
    );
    
    String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    
    public int solution(String s) {
        int answer = 0;
        int idx = 0;
        while(idx < s.length()) {
            answer *= 10;
            for (int i = 0; i < 10; i++) {
                String str = arr[i];
                int endIdx = idx + str.length();
                if (s.charAt(idx) - '0' == i) {
                    answer += i;
                    idx += 1;
                    break;
                }
                if (endIdx <= s.length() && s.substring(idx, endIdx).equals(str)) {
                    answer += i;
                    idx = endIdx;
                    break;
                }
                
                // System.out.println("error");
                // break;
            }
        }
        return answer;
    }
}