import java.util.*;

class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        boolean ret = true;
        for(int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                ret = false;
                break;
            }
        }
        return ret;
    }
}