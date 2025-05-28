package SlidingWindow;

import java.util.*;

public class MaximumNumberOfOccurrenceOfSubstring {
    public static void main(String[] args) {
        String s = "aaaa";
        Solution solution = new Solution();
        System.out.println(solution.maxFreq(s, 1, 3,3));
    }
    static class Solution {
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            Map<Character, Integer> freqMap = new HashMap<>();
            Map<String, Integer> strFreq = new HashMap<>();
            int st = 0, max = 0;
            for(int ed=0; ed<s.length(); ed++) {
                char curr = s.charAt(ed);
                freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
                if(ed-st+1 > minSize) {
                    int freq = freqMap.get(s.charAt(st));
                    freqMap.put(s.charAt(st), freq-1);
                    if(freqMap.get(s.charAt(st)) == 0) {
                        freqMap.remove(s.charAt(st));
                    }
                    st++;
                }
                int len = ed-st+1;
                if(len == minSize && freqMap.size() <= maxLetters) {
                    String sub = s.substring(st, ed+1);
                    strFreq.put(sub, strFreq.getOrDefault(sub, 0) + 1);
                    max = Math.max(max, strFreq.get(sub));
                }
            }
            return max;
        }
    }

/*

s: "bccaaabac"
u: 2
l: 3
e: 3

*/
}
