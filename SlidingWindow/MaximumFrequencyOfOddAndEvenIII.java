package SlidingWindow;

import java.util.*;

public class MaximumFrequencyOfOddAndEvenIII {
    public static void main(String[] args) {
        System.out.println(new Solution().maxDifference("330130303114333", 13));
    }
    static class Solution {
        public int maxDifference(String s, int k) {
            int[] freq = new int[5];
            int n = s.length();
            int[][] prefix = new int[n+1][2];
            prefix[0] = new int[5];
            for(int i=0; i<n; i++) {
                char curr = s.charAt(i);
                freq[curr-'0']++;
                prefix[i+1] = Arrays.copyOf(freq, freq.length);
            }
            int ans = Integer.MIN_VALUE;
            for(int ed=k; ed<=n; ed++) {
                for(int st=0; st<=ed-k; st++) {
                    int diff = diff(prefix[st], prefix[ed], n);
                    if(diff != Integer.MAX_VALUE) {
                        ans = Math.max(diff, ans);
                    }
                }
            }
            return ans;
        }
        public int diff(int[] freq1, int[] freq2, int n) {
            int min = n, max = 0;
            for(int i=0; i<5; i++) {
                int diff = freq2[i] - freq1[i];
                if(diff > 0) {
                    boolean isEven = (diff & 1) == 0;
                    if(isEven) min = Math.min(min, diff);
                    else max = Math.max(max, diff);
                }
            }
            return (min == n || max == 0) ? Integer.MAX_VALUE : max - min;
        }
    }

/*

12233
2

12 23 33
122 1223 12233
223 2233
233


*/
}
