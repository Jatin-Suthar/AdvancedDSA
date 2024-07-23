package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChars {

    public static void main(String[] args) {

        String s = "abbbbbbc";
        int k = 2;
        System.out.println(kDistinctChars(k, s));

    }

    public static int kDistinctChars(int k, String str) {
        int s = 0, res = 0, n = str.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int e = 0; e < n; e++) {
            map.put(str.charAt(e), map.getOrDefault(str.charAt(e), 0) + 1);
            while(map.size()>k) {
                char c = str.charAt(s++);
                if(map.get(c)==1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
            res = Math.max(res, e-s+1);
        }
        return res;
    }

}
