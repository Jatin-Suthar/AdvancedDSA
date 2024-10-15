package DynamicProgrammingPatterns.Knapsack;

public class MinSwapToMakeSequenceIncreasing {

    public static void main(String[] args) {
        int[] nums1 = {3,3,8,9,10}, nums2 = {1,7,4,6,8};
        MinSwapToMakeSequenceIncreasingSolution solution = new MinSwapToMakeSequenceIncreasingSolution();
        System.out.println(solution.minSwap(nums1, nums2));
    }

}

class MinSwapToMakeSequenceIncreasingSolution {
    Integer[][] dp;
    public int minSwap(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length+1][2];
        return Math.min(helper(nums1, nums2, 1, 0), 1+helper(nums1, nums2, 1, 1));
    }
    public int helper(int[] nums1, int[] nums2, int idx, int swapped) {
        if(idx==nums1.length) return 0;

        if(dp[idx][swapped]!=null) return dp[idx][swapped];

        int ans = Integer.MAX_VALUE, prev1 = nums1[idx-1], prev2 = nums2[idx-1];
        //handle previous swap
        if(swapped==1) {
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
        }

        //handle unswap
        if(nums1[idx] > prev1 && nums2[idx] > prev2) {
            ans = helper(nums1, nums2, idx+1, 0);
        }
        //handle swap
        if(nums1[idx] > prev2 && nums2[idx] > prev1) {
            ans = Math.min(ans, 1+helper(nums1, nums2, idx+1, 1));
        }

        return dp[idx][swapped] = ans;
    }
}