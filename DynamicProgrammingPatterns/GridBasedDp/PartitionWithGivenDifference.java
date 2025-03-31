package DynamicProgrammingPatterns.GridBasedDp;

public class PartitionWithGivenDifference {

    public static void main(String[] args) {
        int[] arr =  {1, 1, 1, 1};
        int d = 0;
        PartitionWithGivenDifferenceSolution solution = new PartitionWithGivenDifferenceSolution();
        System.out.println(solution.countPartitions(arr, d));
    }

}
class PartitionWithGivenDifferenceSolution {
    Integer[][] dp;

    public int countPartitions(int[] arr, int d) {
        int totalSum = 0, n = arr.length;
        for (int num : arr)
            totalSum += num;
        if(totalSum < d)
            return 0;
        dp = new Integer[totalSum + 1][n];
        return recur(arr, totalSum, 0, d, n - 1);
    }

    int recur(int[] arr, int totalSum, int sum, int d, int idx) {
        if (idx < 0) {
            return (Math.abs(2 * sum - totalSum) == d && 2 * sum <= totalSum) ? 1 : 0;
        }
        if (dp[sum][idx] != null)
            return dp[sum][idx];
        int include = recur(arr, totalSum, sum + arr[idx], d, idx - 1);
        int exclude = recur(arr, totalSum, sum, d, idx - 1);
        dp[sum][idx] = include + exclude;
        return dp[sum][idx];
    }
}


