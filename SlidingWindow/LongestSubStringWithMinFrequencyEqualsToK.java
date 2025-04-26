package SlidingWindow;

import java.util.*;

public class LongestSubStringWithMinFrequencyEqualsToK {
    public static void main(String[] args) {
        String s = "bbaaacbd";
        int k = 3;
        LongestStringWithMinFrequencyEqualsToKSolution solution
                = new LongestStringWithMinFrequencyEqualsToKSolution();
        System.out.println(solution.longestSubstring(s, k));
    }
}

class LongestStringWithMinFrequencyEqualsToKSolution {
    public int longestSubstring(String s, int k) {
        int[] freq = new int[26];
        int ans = 0, n = s.length(), st = 0;
        char[] carr = s.toCharArray();
        for(char c: carr) {
            freq[c-'a']++;
        }
        boolean valid = true;
        for(int ed=0; ed<n; ed++) {
            char c = carr[ed];
            int currFreq = freq[c-'a'];
            if(currFreq > 0 && currFreq < k) {
                String newSub = s.substring(st, ed);
                ans = Math.max(ans, longestSubstring(newSub, k));
                st = ed+1;
                valid = false;
            }
        }
        return (valid) ? s.length() : Math.max(ans, longestSubstring(s.substring(st), k));
    }
}

/*

baaabcd
3


*/