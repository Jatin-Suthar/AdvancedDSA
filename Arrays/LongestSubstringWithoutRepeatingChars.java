package Arrays;

import java.util.*;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        String s="tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen=0, start=0;
        for(int end = 0; end < s.length(); end++) {
            if(map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end-start + 1);
        }
        return maxLen;
    }

}
