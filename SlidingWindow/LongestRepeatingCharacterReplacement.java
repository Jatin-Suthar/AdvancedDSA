package SlidingWindow;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        LongestRepeatingCharacterReplacementSolution solution = new LongestRepeatingCharacterReplacementSolution();
        System.out.println(solution.characterReplacement(s, k));
    }

}

class LongestRepeatingCharacterReplacementSolution {
    public int characterReplacement(String s, int k) {
        int maxCount = 0, longest = 0, l = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int e=0; e<n; e++) {
            char curr = s.charAt(e);
            map.put(curr, map.getOrDefault(curr, 0)+1);
            maxCount = Math.max(maxCount, map.get(curr));
            if (e-l+1 - maxCount > k) {
                char stChar = s.charAt(l);
                map.put(stChar, map.get(stChar)-1);
                l++;
            }
            longest = Math.max(longest, e-l+1);
        }
        return longest;
    }
}