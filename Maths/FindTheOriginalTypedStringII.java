package DynamicProgramming;

import Oops.Inheritence.A;

import java.util.ArrayList;
import java.util.List;

public class FindTheOriginalTypedStringII {
    public static void main(String[] args) {
//        System.out.println(new Solution().possibleStringCount("aabbccdd", 7));
        int num = 5;
        int bitCount = (int) (Math.log(num) / Math.log(2)) + 1;
        System.out.println(Integer.bitCount(5) + " | " + bitCount);
    }
    static class Solution {
        int MOD = 1000000007;
        Integer[][] dp;
        public int possibleStringCount(String word, int k) {
            List<Integer> freq = new ArrayList<>();
            char[] arr = word.toCharArray();
            int count = 0;
            char prev = arr[0];
            for(char curr: arr) {
                if(prev == curr) count++;
                else {
                    freq.add(count);
                    prev = curr;
                    count = 1;
                }
            }
            freq.add(count);
            dp = new Integer[freq.size()+1][word.length()];
            return recur(freq, k, 0, 0);
        }
        public int recur(List<Integer> freq, int k, int idx, int size) {
            if(idx>=freq.size()) {
                if(size>=k) return 1;
                return 0;
            }
            if(dp[idx][size]!=null) return dp[idx][size];
            int count = 0;
            for(int i=1; i<=freq.get(idx); i++) {
                count = (count + recur(freq, k, idx+1, size+i))%MOD;
            }
            return dp[idx][size]=count;
        }
    }
/*

aaabbb

a: 1 | b: 1 | W
a: 1 | b: 2 | R
a: 1 | b: 3 | R
a: 2 | b: 1 | R
a: 2 | b: 2 | R
a: 2 | b: 3 | R
a: 3 | b: 1 | R
a: 3 | b: 2 | R
a: 3 | b: 3 | R

*/
/*

aaabbb

a: 1 | b: 1 | W
a: 1 | b: 2 | R
a: 1 | b: 3 | R
a: 2 | b: 1 | R
a: 2 | b: 2 | R
a: 2 | b: 3 | R
a: 3 | b: 1 | R
a: 3 | b: 2 | R
a: 3 | b: 3 | R

*/
}
