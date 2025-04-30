import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // Please write your code here.
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        Character c = null;
        for(Map.Entry<Character, Integer> e : set) {
            if (e.getValue() == 1){
                c = e.getKey();
                break;
            }
        }
        if (c == null) {
            System.out.println("None");
        } else {
            System.out.println(c);
        }
    }
}