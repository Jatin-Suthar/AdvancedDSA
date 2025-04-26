package SlidingWindow;

public class MaximumSubNonOverlappingSum {
    public static void main(String[] args) {
        int[] nums = {0,6,5,2,2,5,1,9,4};
        int firstLen = 1;
        int secondLen = 2;
        MaximumSubNonOverlappingSumSolution solution = new MaximumSubNonOverlappingSumSolution();
        System.out.println(solution.maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }
}

class MaximumSubNonOverlappingSumSolution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n;
        int[] pSum = new int[n = nums.length];
        for(int i=0; i<n; i++) {
            if(i==0) {
                pSum[i] = nums[i];
            } else {
                pSum[i] = pSum[i-1] + nums[i];
            }
        }
        int st = -1, ans = 0;
        for(int ed = firstLen-1; ed<n; ed++) {
            int currSum = (ed == firstLen-1) ? pSum[ed] : pSum[ed]-pSum[st];
            int leftSum = maxSum(pSum, 0, st, secondLen);
            int rightSum = maxSum(pSum, ed+1, n, secondLen);
            ans = Math.max(ans, currSum + Math.max(leftSum,rightSum));
            st++;
        }
        return ans;
    }
    public int maxSum(int[] pSum, int st, int ed, int k) {
        int ans = 0;
        for(int i=st+k-1; i<ed; i++) {
            ans = Math.max(ans, (st==0) ? pSum[i] : pSum[i]-pSum[st-1]);
            st++;
        }
        return ans;
    }
}
/*
[3,11,12,15,17,18,26,35,35]
[0,14,]
*/