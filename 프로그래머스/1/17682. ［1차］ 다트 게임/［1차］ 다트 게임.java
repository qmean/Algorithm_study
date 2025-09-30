import java.util.*;

class Solution {
    public int solution(String msg) {
        int start = 0;
        int end = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        while(end < msg.length()) {
            while(end < msg.length() 
                  && '0' <= msg.charAt(end) 
                  && msg.charAt(end) <= '9') end++;
            
            int value = Integer.parseInt(msg.substring(start, end));
            if (msg.charAt(end) == 'D') {
                value = (int)Math.pow(value, 2);
            } else if (msg.charAt(end) == 'T') {
                value = (int)Math.pow(value, 3);
            }
            
            end++;
            
            if (end >= msg.length()) {
                dq.add(value);
                break;
            }
            
            if (msg.charAt(end) == '*') {
                value *= 2;
                int before = dq.pollLast();
                dq.add(before * 2);
                end++;
            } else if (msg.charAt(end) == '#') {
                value *= -1;
                end++;
            }
            dq.add(value);
            start = end;
        }
        
        int answer = 0;
        while (!dq.isEmpty()) {
            // System.out.println(dq.peek());
            answer += dq.poll();
        }
        return answer;
    }
}