import java.util.*;

class Solution {
    
    Map<String,String> format = 
        Map.of("Enter", "%s님이 들어왔습니다.", "Leave", "%s님이 나갔습니다.");
    
    public String[] solution(String[] record) {
        Map<String, String> name = new HashMap<>();
        Map<String, String> cur = new HashMap<>();
        Map<String, Boolean> entering = new HashMap<>();
        List<Segment> msg = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            String type = s[0];
            String uid = s[1];
            if (s[0].equals("Enter")) {
                String nickName = s[2];
                msg.add(new Segment(type, uid));
                // 참가중 표시
                entering.put(uid, true);
                // 최종 닉네임 추가
                cur.put(uid, nickName);
                // 닉네임 상태에 추가
                name.put(uid, nickName);
            } else if (s[0].equals("Change")){
                String newName = s[2];
                // 현재 닉네임 상태에 추가
                name.put(uid, newName);
                // 이름 변경시 채팅 참여중이라면
                if (entering.get(uid)) {
                    // 최종 포매팅에 추가
                    cur.put(uid, newName);
                }
            } else {
                msg.add(new Segment(type, uid));
                entering.put(uid, false);
            }
        }
        String[] answer = new String[msg.size()];
        for (int i = 0; i < msg.size(); i++) {
            answer[i] = msg.get(i).print(cur.get(msg.get(i).uid));
        }
        
        return answer;
    }
    
    public class Segment {
        String type;
        String uid;
        
        public Segment(String type, String uid) {
            this.type = type;
            this.uid = uid;
        }
        
        public String print(String nickName) {
            return String.format(format.get(type), nickName);
        }
    }
}