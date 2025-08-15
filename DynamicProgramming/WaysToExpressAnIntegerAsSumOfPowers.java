package DynamicProgramming;

public class WaysToExpressAnIntegerAsSumOfPowers {
    public static void main(String[] args) {
        for(int i=0; i<30; i++) {
            System.out.println((int) Math.pow(3, i));
        }
//        System.out.println(new Solution().numberOfWays(4, 1));
    }
    static class Solution {
        Integer[][] dp;
        int end;
        public int numberOfWays(int n, int x) {
            end = n;
            dp = new Integer[n+1][n+1];
            return recur(n, x, 1);
        }
        public int recur(int n, int x, int idx) {
            if(n==0) return 1;
            if(idx>end) return 0;
            if(n<0) return 0;
            if(dp[n][idx]!=null) return dp[n][idx];
            return dp[n][idx] = recur(n-((int)Math.pow(idx, x)), x, idx+1)
                              + recur(n, x, idx+1);
        }
    }
}
