import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Segment[] answer = new Segment[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = new Segment(files[i]);
        }
        Arrays.sort(answer, (s1, s2) -> {
           if (!s1.head.equals(s2.head)) {
               return s1.head.compareTo(s2.head);
           } else {
               return s1.number - s2.number;
           }
        });
        String[] ret = new String[answer.length];
        for (int i = 0; i < answer.length; i++) {
            ret[i] = answer[i].file;
        }
        return ret;
    }
    
    public class Segment {
        String head;
        int number;
        String file;
        
        public Segment (String file) {
            this.file = file;
            int start = 0;
            int end = 0;
            while('0' > file.charAt(end) || file.charAt(end) > '9') {
                end++;
            }
            this.head = file.substring(start, end).toLowerCase();
            start = end;
            while(
                end < file.length() && 
                '0' <= file.charAt(end) && 
                file.charAt(end) <= '9') {
                end++;
            }
            this.number = Integer.parseInt(file.substring(start, end));
        }
    }
}