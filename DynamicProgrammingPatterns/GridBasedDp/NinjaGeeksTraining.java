package DynamicProgrammingPatterns.GridBasedDp;

public class NinjaGeeksTraining {
    public int maximumPoints(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[arr.length][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for(int i=1; i<n; i++) {
            dp[i][0] = arr[i][0] + Math.max(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
    }
}
