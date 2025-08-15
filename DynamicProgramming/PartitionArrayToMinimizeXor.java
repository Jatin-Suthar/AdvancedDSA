package DynamicProgramming;

public class PartitionArrayToMinimizeXor {
    public static void main(String[] args) {
        System.out.println(new Solution().minXor(new int[]{2,3,3,2}, 3));
    }
    static class Solution {
        Integer[][] dp;
        int[] prefix;
        int n;

        public int minXor(int[] nums, int k) {
            n = nums.length;
            prefix = new int[n + 1];
            dp = new Integer[n + 1][k + 1];
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] ^ nums[i];
            }
            return dfs(0, k);
        }

        private int dfs(int start, int k) {
            if (dp[start][k] != null) return dp[start][k];

            if (k == 1) {
                return prefix[n] ^ prefix[start];
            }

            int minMax = Integer.MAX_VALUE;

            for (int end = start + 1; end <= n - k + 1; end++) {
                int currXor = prefix[end] ^ prefix[start];
                int rest = dfs(end, k - 1);
                minMax = Math.min(minMax, Math.max(currXor, rest));
            }

            return dp[start][k] = minMax;
        }
    }
/*
3
[2,3,3,2]
 0
[0,2,1,2,0]

st: 0
ed: 1

*/
}
