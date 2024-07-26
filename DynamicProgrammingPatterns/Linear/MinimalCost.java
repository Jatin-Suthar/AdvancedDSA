package DynamicProgrammingPatterns.Linear;

import java.util.Arrays;

public class MinimalCost {

    public static void main(String[] args) {
        int n = 5, k = 3;
        int[] heights = {10, 30, 40, 50, 20};
        MinimalCostSolution solution = new MinimalCostSolution();
        System.out.println(solution.minimizeCost(heights, n, k));
    }

}

class MinimalCostSolution {
    Integer[] dp;
    public int minimizeCost(int[] arr, int N, int K) {
        dp = new Integer[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<N; i++) {
            int t = 1;
            while(i-t>=0 && t<=K) {
                dp[i] = Math.min(dp[i], Math.abs(arr[i]-arr[i-t])+dp[i-t]);
                t++;
            }
        }
        return dp[N-1];
    }
}
