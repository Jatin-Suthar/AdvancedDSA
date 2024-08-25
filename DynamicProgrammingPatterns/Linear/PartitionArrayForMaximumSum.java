package DynamicProgrammingPatterns.Linear;

public class PartitionArrayForMaximumSum {
}

class PartitionArrayForMaximumSumSolution {
    Integer[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length+1];
        return recur(arr, k, 0);
    }
    public int recur(int[] arr, int k, int idx) {
        if(idx >= arr.length) return 0;
        if(dp[idx]!=null) return dp[idx];
        int maxSum = 0, sum = 0, maxEle = 0, len = 0;
        for(int i=idx; i<Math.min(idx+k, arr.length); i++) {
            len++;
            maxEle = Math.max(arr[i], maxEle);
            sum = (maxEle*len) + recur(arr, k, i+1);
            maxSum = Math.max(maxSum, sum);
        }
        return dp[idx] = maxSum;
    }
}