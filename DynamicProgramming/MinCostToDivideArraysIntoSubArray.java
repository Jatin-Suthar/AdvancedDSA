package DynamicProgramming;

import java.util.*;

public class MinCostToDivideArraysIntoSubArray {

    public static void main(String[] args) {
        int[] nums = {3,1,4}, cost = {4,6,6};
        int k = 1;

        MinCostToDivideArraysIntoSubArraySolution solution = new MinCostToDivideArraysIntoSubArraySolution();
        System.out.println(solution.minimumCost(nums, cost, k));
    }

}

class MinCostToDivideArraysIntoSubArraySolution {
    public long minimumCost(int[] nums, int[] cost, int k) {
        int n = nums.length;
        long[] nSum = new long[n];
        long[] cSum = new long[n];
        nSum[0] = nums[0];
        cSum[0] = cost[0];
        for(int i=1; i<n; i++) {
            nSum[i] = nSum[i-1]+nums[i];
        }
        for(int i=1; i<n; i++) {
            cSum[i] = cSum[i-1]+cost[i];
        }
        Long[][] dp = new Long[n][n];
        return solve(0, 0, k, nSum, cSum, dp);
    }

    public long solve(int start, int end, int k, long[] prefixNums, long[] prefixCosts, Long[][] dp) {
        int n = prefixNums.length;
        if (end == n) {
            if (start == n) return 0;
            return Long.MAX_VALUE;
        }

        if (dp[start][end] != null) return dp[start][end];

        long currentNumsSum = prefixNums[end], currentCostSum = prefixCosts[n - 1];

        if (start != 0){
            currentNumsSum = prefixNums[end] - prefixNums[start - 1];
            currentCostSum = prefixCosts[n - 1] - prefixCosts[start - 1];
        }

        long currentSubArrayCost = (currentNumsSum + k) * currentCostSum;

        long costIfCutHere = currentSubArrayCost + solve(end + 1, end + 1, k, prefixNums, prefixCosts, dp);
        long costIfExtend = solve(start, end + 1, k, prefixNums, prefixCosts, dp);

        return dp[start][end] = Math.min(costIfCutHere, costIfExtend);
    }
}


/*

[4,8,5,1,14,2,2,12,1]

[7,2,8,4,2,2,1,1,2]

4 12 17 18 32 34 36 48 49

7 9  17 21 23 25 26 27 29

s
     e
currNumsSum: 17
currCostSum: 29
currSubArrayCost: (17+7)*29

(17 + 7*1) * (17)

*/