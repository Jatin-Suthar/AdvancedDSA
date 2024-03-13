package DynamicProgramming;

import java.util.*;

public class LongestStringChain {

    public static void main(String[] args) {
        String[] words = {"a","ab","ac","bd","abc","abd","abdd"};
        Solution_LongestStringChain solutionLongestStringChain = new Solution_LongestStringChain();
        int res = solutionLongestStringChain.longestStrChain(words);
        System.out.print(res);
    }

}

class Solution_LongestStringChain {

    Integer dp[];

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        dp = new Integer[words.length];
        int len = words.length;
        int ans = 0;
        for(int i = 0; i < words.length; i++) {
            ans = Math.max(ans, dfs(words, i+1, words[i])+1);
        }
        return ans;
    }

    public int recur(String words[], int idx, String currWord) {
        if(idx >= words.length) return 0;

        if(dp[idx] != null) return dp[idx];

        int max = 0;
        for(int i=idx; i<words.length; i++) {
            int diff = Math.abs(words[idx].length() - currWord.length());
            if(diff == 0) continue;
            if(diff > 1) break;
            if(isPredecessor(words[i], currWord)) {
                max = Math.max(max, 1+recur(words, i+1, words[i]));
            }
        }

        return dp[idx] = max;
    }

    private int dfs(String[] words, int index, String prev) {
        if(index >= words.length) return 0;
        if(dp[index] != null) return dp[index];
        int result = 0;
        for(int i = index; i < words.length; i++) {
            int diff = words[i].length() - prev.length();
            if(diff == 0) continue;
            if(diff > 1) break;
            if(isPredecessor(prev, words[i])) {
                result = Math.max(result, 1 + dfs(words, i + 1, words[i]));
            }
        }
        return dp[index] = result;
    }

    private boolean isPredecessor(String s1, String s2) {
        if(s2.length() < s1.length()) return isPredecessor(s2, s1);
        int s1Index = 0;
        for(int i = 0; i < s2.length(); i++) {
            final char c1 = s1.charAt(s1Index);
            final char c2 = s2.charAt(i);
            if(c1 == c2) {
                s1Index++;
            }
            if(s1Index >= s1.length()) {
                return true;
            }
        }
        return false;
    }
}