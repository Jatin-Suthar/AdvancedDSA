package Strings;

import java.util.Arrays;

public class LongestCommonPrefixFromAdjacentStringsAfterRemoval {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().longestCommonPrefix(
                new String[]{"jump", "sdfs", "run", "jump", "run"}
        )));
    }
    static class Solution {
        public int[] longestCommonPrefix(String[] words) {
            int n = words.length;
            int[][] prefix = new int[n][2];
            int[][] suffix = new int[n][2];
            for(int i=1; i<n; i++) {
                prefix[i][0] = Math.max(prefix[i-1][0], prefix[i-1][1]);
                prefix[i][1] = Math.max(prefix[i][0], prefixLen(words[i], words[i-1]));
                suffix[n-i-1][0] = Math.max(suffix[n-i][0], suffix[n-i][1]);
                suffix[n-i-1][1] = Math.max(suffix[n-i-1][0], prefixLen(words[n-i-1], words[n-i]));
            }
            int[] ans = new int[n];
            for(int i=0; i<n; i++) {
                ans[i] = Math.max(prefix[i][0], suffix[i][0]);
                if(i!=0 && i!=n-1) {
                    ans[i] = Math.max(ans[i], prefixLen(words[i-1], words[i+1]));
                }
            }
            return ans;
        }
        public int prefixLen(String a, String b) {
            if(a.length()>b.length()) return prefixLen(b, a);
            int count = 0;
            for(int i=0; i<a.length(); i++) {
                if(a.charAt(i) != b.charAt(i)) return count;
                count++;
            }
            return count;
        }
    }
/*
["jump","sdfs","run","jump","run"]

["jump","sdfs","run","run"]

prefix: []


*/
}
