import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] t = new int[n];
        PriorityQueue<Person> person = new PriorityQueue<>((p1, p2) -> {
            return p1.start - p2.start;
        });
        PriorityQueue<Person> waiting = new PriorityQueue<>((p1, p2) -> {
            return p1.num - p2.num;
        });
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int duration = sc.nextInt();
            person.add(new Person(i, start, duration));
        }
        // Please write your code here.

        long ans = 0;
        long time = 0;
        while(!person.isEmpty() || !waiting.isEmpty()) {
            // 대기자 명단 최신화
            while(!person.isEmpty() && person.peek().start <= time) {
                Person p = person.poll();
                waiting.add(p);
            }

            if (waiting.isEmpty()) {
                time = person.peek().start;
                continue;
            }

            // 가장 우선순위의 대기자 뽑아서 입장
            Person p = waiting.poll();
            // System.out.format("p = %d %d %d and waiting for %d\n", p.num, p.start, p.duration, time - p.start);
            ans = Math.max(ans, time - p.start);
            time += p.duration;
        }

        System.out.println(ans);
    }

    public static class Person {
        int num;
        int start;
        int duration;

        public Person(int num, int start, int duration) {
            this.num = num;
            this.start = start;
            this.duration = duration;
        }
    }
}

// waiting queue 필요