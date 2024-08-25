package DynamicProgrammingPatterns.Linear;

public class BestTimeToBuyAndSaleWithTransactionFee {
}

class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new Integer[prices.length+1][2];
        return recur(prices, fee, 0, 1);
    }
    public int linear(int[] prices, int fee) {
        int n = prices.length;
        int[][] memo = new int[n+1][2];
        for (int i = n-1; i >= 0; i--) {
            memo[i][0] = Math.max( prices[i]+memo[i+1][1]-fee, memo[i+1][0]);
            memo[i][1] = Math.max(-prices[i]+memo[i+1][0], memo[i+1][1]);
        }
        return memo[0][0];
    }
    public int recur(int[] prices, int fee, int idx, int buy) {
        if(idx>=prices.length) return 0;
        if(dp[idx][buy]!=null) return dp[idx][buy];
        int max = 0;
        if(buy==1) {
            max = Math.max(-prices[idx]+recur(prices, fee, idx+1, 0),
                                        recur(prices, fee, idx + 1, 1));
        } else {
            max = Math.max( prices[idx]+recur(prices, fee, idx+1, 1)-fee,
                                        recur(prices, fee, idx + 1, 0));
        }
        return dp[idx][buy] = max;
    }
}
