package DynamicProgramming;

public class MinSumToReachEndInGrid {
	public static void main(String[] args) {
		
	}

	int dp[][];
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++) 
                dp[i][j] = -1;
        return helper(grid, 0, 0, 0, grid.length, grid[0].length);
    }
    public int helper(int[][] grid, int i, int j, int sum, int n, int m) {
        if(i>=n || j>=m) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int down = helper(grid, i+1, j, sum, n, m);
        int top = helper(grid, i, j+1, sum, n, m);
        if(Math.min(top, down)==Integer.MAX_VALUE) dp[i][j]=grid[i][j];
        else dp[i][j]=Math.min(top, down)+grid[i][j];
        return dp[i][j];
    }
}
