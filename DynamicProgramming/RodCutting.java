package DynamicProgramming;

public class RodCutting {
}

class RodCuttingSolution {
    Integer[] dp;
    public int cutRod(int price[], int n) {
        dp = new Integer[n+1];
        return dfs(price, n, 0);
    }
    public int dfs(int[] price, int n, int idx) {
        if(idx>=n) return 0;
        if(dp[idx]!=null) return dp[idx];
        int max = 0;
        for(int i=idx; i<n; i++) {
            max = Math.max(max, dfs(price, n, i+1)+price[i-idx]);
        }
        return dp[idx] = max;
    }
}