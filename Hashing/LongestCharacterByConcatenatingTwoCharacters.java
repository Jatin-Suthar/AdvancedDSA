package Hashing;

import java.util.*;

public class LongestCharacterByConcatenatingTwoCharacters {
    public static void main(String[] args) {
        String[] words = {"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"};
        System.out.println(new Solution().longestPalindrome(words));
    }
    static class Solution {
        public int longestPalindrome(String[] words) {
            int palindromePairs = 0, equals = 0;
            Map<String, Integer> map = new HashMap<>();
            for (String cur : words) {
                String rev = reverse(cur);
                if (cur.equals(rev)) equals++;
                Integer freq = map.get(rev);
                if (null != freq) {
                    palindromePairs += 2;
                    map.put(rev, freq - 1);
                    if (map.get(rev) == 0) map.remove(rev);
                } else {
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
            return 2*(palindromePairs+(((equals&1) == 1) ? 1 : 0));
        }
        public String reverse(String s) {
            return s.charAt(1) + "" + s.charAt(0);
        }
    }
}
