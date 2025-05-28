package DynamicProgrammingPatterns.BitMasking;

public class NumberOfWaysToPaint3x3Matrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numOfWays(2));
    }
    static class Solution {
        public int numOfWays(int n) {
            dp = new Integer[n+1][64];
            return recur(n, 3, 0, 0, 0, 0);
        }
        Integer MOD = 1000000007;
        Integer[][] dp;
        public int recur(int n, int m, int i, int j, int left, int prev) {
            if(j==m) {
                left = prev;
                prev = 0;
                i++;
                j=0;
            }
            if(i==n) return 1;
            if(j == 0 && dp[i][left] != null) return dp[i][left];
            int ans = 0;
            for(int color=1; color<=3; color++) {
                int leftColor = (left >> (2*(m-j-1))) & 3;
                int prevColor = (prev & 3);
                if(leftColor!=color && prevColor!=color) {
                    ans = (ans + recur(n, m, i, j+1, left, ((prev<<2) | color)))%MOD;
                }
            }
            return dp[i][left] = ans;
        }
    }
}

