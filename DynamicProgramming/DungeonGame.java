package DynamicProgramming;

public class DungeonGame {
	public int calculateMinimumHP(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int dp[][]=new int[n][m];
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                if(i==n-1 && j==m-1) dp[i][j]=Math.min(0, a[i][j]);
                else if(i==n-1) dp[i][j]=Math.min(0, a[i][j]+dp[i][j+1]);
                else if(j==m-1) dp[i][j]=Math.min(0, a[i][j]+dp[i+1][j]);
                else dp[i][j]=Math.min(0, a[i][j]+Math.max(dp[i][j+1], dp[i+1][j]));
            }
        }
        return 1-dp[0][0];
    }
}
