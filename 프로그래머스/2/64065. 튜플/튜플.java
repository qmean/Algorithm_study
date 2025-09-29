import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("\\},\\{");
        List<List<Integer>> list = new ArrayList<>();
        for (String str : arr) {
            String[] sarr = str.split(",");
            List<Integer> tmp = new ArrayList<>();
            for (String inp : sarr) {
                tmp.add(Integer.parseInt(inp));
            }
            list.add(tmp);
        }
        list.sort((l1, l2) -> l1.size() - l2.size());
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (List<Integer> ansList : list) {
            ansList.forEach(i -> set.add(i));
        }
        int[] answer = new int[list.size()];
        int idx = 0;
        for (int input : set) {
            answer[idx] = input;
            idx++;
        }
        return answer;
        // int[] answer = {};
        // return answer;
    }
}