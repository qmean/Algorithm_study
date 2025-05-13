import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        TreeSet<Person> set = new TreeSet<>((p1, p2) -> {
            // if (p1.start != p2.start) {
                return p1.start - p2.start;
            // }
        });
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int speed = sc.nextInt();
            Person p = Person.of(start, speed);

            boolean next = false;
            
            // // p 가 다른 사람의 그룹에 들어감
            Person cur = p;
            // while (set.higher(cur) != null) {
            //     cur = set.higher(cur);
            //     // 두 조건을 만족하는 경우 합쳐짐 (p를 집어넣지 않음)
            //     if (cur.speed < p.speed) {
            //         if ((cur.start - p.start) / (p.speed - cur.speed) < t) {
            //             next = true;
            //             break;
            //         }
            //     }
            // }

            // if (next)
            //     continue;

            // 다른 그룹이 p에 들어감
            cur = p;
            while (set.lower(cur) != null) {
                cur = set.lower(cur);
                // 두 조건을 만족하는 경우 합쳐짐 (p를 집어넣고 새로운걸 삭제)
                if (cur.speed > p.speed) {
                    if ((p.start - cur.start) / (cur.speed - p.speed) < t) {
                        // set.remove(cur);
                        // set.add(p);
                        next = true;
                        break;
                    }
                }
            }

            if (next)
                continue;

            // 맨 처음인 경우 혹은 만나는게 아예 없는 경우
            set.add(p);
        }
        // Please write your code here.
        System.out.println(set.size());
    }

    public static class Person {
        int start;
        int speed;

        public static Person of(int s, int sp) {
            Person p = new Person();
            p.start = s;
            p.speed = sp;
            return p;
        }
    }
}