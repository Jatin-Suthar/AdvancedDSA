package DynamicProgramming;

public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        int[] arr = {14,9,10,12,4,8,1,16};
        BestTimeToBuyAndSellStockIIISolution solution = new BestTimeToBuyAndSellStockIIISolution();
        System.out.println(solution.maxProfit(arr));
    }

}

class BestTimeToBuyAndSellStockIIISolution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];
        return dfsDp(prices, n, 0, 0);
    }
    public int dfsDp(int[] nums, int n, int idx, int count) {
        if(count>=2 || idx>=n-1) {
            return 0;
        }
        if(dp[idx][count] != null) {
            return dp[idx][count];
        }
        int max = Integer.MIN_VALUE;
        for(int i=idx; i<n; i++) {
            max = Math.max(max, (nums[i]-nums[idx])+dfsDp(nums, n, i+1, count+1));
        }
        return dp[idx][count] = Math.max(max, dfsDp(nums, n, idx+1, count));
    }
}