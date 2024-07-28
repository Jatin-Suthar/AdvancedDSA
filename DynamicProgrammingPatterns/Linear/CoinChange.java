package DynamicProgrammingPatterns.Linear;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1};
        int target = 2;
        CoinChangeSolution solution = new CoinChangeSolution();
        System.out.println(solution.coinChange(coins, target));
    }

}

class CoinChangeSolution {
    Integer[] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new Integer[amount+1];
        int res = recur(coins, amount, n);
        return (res>=100001) ? -1 : res;
    }
    public int coinChangeItr(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for(int i=1; i<=amount; i++) {
            for(int coin: coins) {
                if(i-coin >= 0) {
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }
        return (dp[amount]>=100001) ? -1 : dp[amount];
    }
    public int recur(int[] coins, int amount, int n) {
        if(amount<=0)
            return (amount==0) ? 0 : 100001;
        if(dp[amount]!=null) return dp[amount];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            min = Math.min(min, 1+recur(coins, amount-coins[i], n));
        }
        return dp[amount]=min;
    }
}