package DynamicProgrammingPatterns.BitMasking;

import java.util.*;

public class FindTheMaximumSumOfNodeValues {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int k = 3;
        int[][] edges = {{0,1},{0,2}};
        Solution solution = new Solution();
        System.out.println(solution.maximumValueSum(nums, k, edges));
    }
    static class Solution {
        //This solution only works for m up to 20 length
        public long maximumValueSum1(int[] nums, int k, int[][] edges) {
            int m = edges.length;
            int fullMask = (1 << m) - 1;
            Long[] memo = new Long[1 << m];
            long baseSum = 0;
            for (int x : nums) baseSum += x;
            return baseSum + dfs1(0, fullMask, nums, k, edges, memo);
        }
        private long dfs1(int mask, int fullMask, int[] nums, int k, int[][] edges, Long[] memo) {
            if (mask == fullMask) return 0;
            if (memo[mask] != null) return memo[mask];
            long best = 0;
            int m = edges.length;
            for (int i = 0; i < m; i++) {
                int bit = 1 << i;
                if ((mask & bit) == 0) {
                    int u = edges[i][0], v = edges[i][1];
                    long normal = nums[u] + nums[v];
                    long xor = (nums[u] ^ k) + (nums[v] ^ k);
                    long gain = xor > normal ? xor - normal : 0;
                    best = Math.max(best, gain + dfs1(mask | bit, fullMask, nums, k, edges, memo));
                }
            }
            return memo[mask] = best;
        }

        public long maximumValueSum(int[] nums, int k, int[][] edges) {
            long base   = 0;
            long sumPos = 0;
            int  cntPos = 0;
            long minPos = Long.MAX_VALUE;
            long maxNeg = Long.MIN_VALUE;

            for (int x : nums) {
                base += x;
                long d = (long)(x ^ k) - x;
                if (d > 0) {
                    sumPos += d;
                    cntPos++;
                    if (d < minPos) minPos = d;
                } else {
                    if (d > maxNeg) maxNeg = d;
                }
            }

            if ((cntPos & 1) == 0) {
                return base + sumPos;
            } else {
                long fix = Math.max(maxNeg, -minPos);
                return base + sumPos + fix;
            }
        }
    }
/*

101



        41
        101001
        000011

        42
        101010

        41
        101001
        000011

        42
        101010

        40
        101000
        000011

        43
        101011


        42+41+43

        126

        41+42+43

        126

7

101
011

110
011

1101
0011
1110
0011
1101

*/
}
