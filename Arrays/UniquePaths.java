package Arrays;

public class UniquePaths {

    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        return recur(0, 0, m, n);
    }
    public int recur(int i, int j, int m, int n) {
        if(i==m-1 && j==n-1) {
            return 1;
        }
        if(i>=m || j>=n || i<0 || j<0) {
            return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];
        int count = 0;
        count += recur(i, j+1, m, n);
        count += recur(i+1, j, m, n);
        return dp[i][j]=count;
    }

}
