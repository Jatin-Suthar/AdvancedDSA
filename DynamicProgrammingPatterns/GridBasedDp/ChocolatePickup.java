package DynamicProgrammingPatterns.GridBasedDp;

public class ChocolatePickup {
}

class Solution {
    Integer[][][] dp;
    public int solve(int n, int m, int[][] grid) {
        dp = new Integer[n+1][m+1][m+1];
        return recur(n, m, grid, 0, 0, m-1);
    }
    public int recur(int n, int m, int[][] grid, int i, int aIdx, int bIdx) {
        int chocolateCollected = 0;
        if(aIdx < 0 || bIdx < 0 || aIdx >= m || bIdx >= m || i >= n) {
            return 0;
        }
        if(dp[i][aIdx][bIdx] != null) return dp[i][aIdx][bIdx];
        if(aIdx == bIdx) {
            chocolateCollected += grid[i][aIdx];
        } else {
            chocolateCollected += grid[i][aIdx];
            chocolateCollected += grid[i][bIdx];
        }
        return dp[i][aIdx][bIdx] = chocolateCollected + Math.max(recur(n, m, grid, i+1, aIdx-1, bIdx-1),
                                                        Math.max(recur(n, m, grid, i+1, aIdx-1, bIdx),
                                                        Math.max(recur(n, m, grid, i+1, aIdx-1, bIdx+1),
                                                        Math.max(recur(n, m, grid, i+1, aIdx, bIdx-1),
                                                        Math.max(recur(n, m, grid, i+1, aIdx, bIdx),
                                                        Math.max(recur(n, m, grid, i+1, aIdx, bIdx+1),
                                                        Math.max(recur(n, m, grid, i+1, aIdx+1, bIdx-1),
                                                        Math.max(recur(n, m, grid, i+1, aIdx+1, bIdx),
                                                                 recur(n, m, grid, i+1, aIdx+1, bIdx+1)))))))));
    }
}

/*

3 1 1
2 5 1
1 5 5
2 1 1

*/