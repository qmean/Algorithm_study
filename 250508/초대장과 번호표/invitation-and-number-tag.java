import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g = sc.nextInt();
        // Please write your code here.
        List<Set<Integer>> list = new LinkedList<>();
        for(int i = 0; i < g; i++) {
            Set<Integer> set = new HashSet<>();
            list.add(set);
            int a = sc.nextInt();
            for(int j = 0; j < a; j++) {
                set.add(sc.nextInt());
            }
        }
        
        int cnt = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        while(!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            for(Set<Integer> set : list) {
                if (!set.contains(cur))
                    continue;
                set.remove(cur);
                if (set.size() == 1) {
                    int i = set.iterator().next();
                    q.add(i);
                }
            }
        }

        System.out.println(cnt);
    }
}


/*
1부터 n까지의 번호표 가진 사람들
g개의 그룹

조건)
1. 한 사람은 여러 그룹에 속할 수 있음
2. 그룹 내 모든 멤버가 일치할 수는 없음
3. 사람들에게 초대장을 나누어줌
3-1. 그룹 인원수가 k인 그룹에서 k-1명의 사람들이 초대장을 받은 경우 나머지 한 사람도 무조건 초대장을 받아야 함

문제)
초대장 나눠주기

해결)
1번부터 n번의 사람을 숫자로 구분
각 그룹의 사람을 그룹마다 set으로 저장
모든 set에서 1 삭제
나머지 set에서 1명만 남은 set은 하나의 원소 삭제 -> 그 원소에 해당하는 사람도 1 삭제와 같이 동작
무한반복
*/