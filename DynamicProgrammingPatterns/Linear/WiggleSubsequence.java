package DynamicProgrammingPatterns.Linear;

public class WiggleSubsequence {

    public static void main(String[] args) {

        WiggleSubsequenceSolution ws = new WiggleSubsequenceSolution();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(ws.wiggleMaxLength(nums));

    }

}

class WiggleSubsequenceSolution {
    Integer[][] dp;
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        dp = new Integer[n+1][2];
        return Math.max(recur(nums, 0, 1, -1, n), recur(nums, 0, 0, -1, n));
    }
    public int recur(int[] nums, int idx, int wiggle, int prev, int n) {
        if(n==1) return 0;
        if(idx>=n) return 0;
        int diff = nums[idx]-prev;
        if(dp[idx][wiggle]!=null)
            return dp[idx][wiggle];
        int count = 0;
        if(prev == -1) {
            count = Math.max(count, (1+recur(nums, idx+1, wiggle, nums[idx], n)));
        } else if((wiggle==1 && diff>0) || (wiggle==0 && diff<0)) {
            count = Math.max(count, (1+recur(nums, idx+1, 1-wiggle, nums[idx], n)));
        }
        return dp[idx][wiggle] = Math.max(count, recur(nums, idx+1, wiggle, prev, n));
    }
}