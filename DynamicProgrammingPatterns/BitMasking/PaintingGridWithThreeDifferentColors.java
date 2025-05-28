package DynamicProgrammingPatterns.BitMasking;

public class PaintingGridWithThreeDifferentColors {
    public static void main(String[] args) {
        int m = 2, n = 2;
        System.out.println(new Solution().colorTheGrid(m, n));
    }
    static class Solution {
        Integer MOD = 1000000007;
        Integer[][] dp;
        public int colorTheGrid(int m, int n) {
            dp = new Integer[n+1][1024];
            return recur(m,n,0,0,0,0);
        }
        public int recur(int m, int n, int i, int j, int left, int prev) {
            if(i==m) {
                left = prev;
                prev = 0;
                i=0;
                j++;
            }
            if(j==n) return 1;
            if(i == 0 && dp[j][left] != null) return dp[j][left];
            int ans = 0;
            for(int color=1; color<=3; color++) {
                int leftColor = (left >> (2*(m-i-1))) & 3;
                int prevColor = (prev & 3);
                if(leftColor!=color && prevColor!=color) {
                    ans = (ans + recur(m, n, i+1, j, left, ((prev<<2) | color)))%MOD;
                }
            }
            return dp[j][left] = ans;
        }
    }
/*

ab
bc


[a][c]
[b][a]

rg
g

*/
/*

ab
bc

3

1110

[a][c]
[b][a]

rg
g

*/
}
