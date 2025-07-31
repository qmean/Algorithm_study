import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        Map<Character, Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();
        
        int j = 0;
        int max = Integer.MIN_VALUE;
        map.put(arr[0], 1);
        for(int i = 0; i < arr.length; i++) {
            while(j+1 < arr.length && !(map.size() == k && !map.containsKey(arr[j+1]))) {
                map.put(arr[j+1], map.getOrDefault(arr[j+1], 0) + 1);
                j++;
            }

            max = Math.max(max, j - i + 1);
            
            if (map.get(arr[i]) == 1) {
                map.remove(arr[i]);
            } else {
                map.put(arr[i], map.get(arr[i]) - 1);
            }
        }

        System.out.println(max);
    }
}