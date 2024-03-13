package Arrays;

import java.util.Arrays;

//JumpGameII on Leetcode
public class MinNumberOfJumpsToReachEnd {

    public int jumpUsingGreedyApproach(int[] nums) {
        int jump = 0;
        int posi = 0;
        int max = 0;
        for(int i=0; i<nums.length-1; i++) {
            max = Math.max(max, i+nums[i]);
            if(i == posi) {
                jump++;
                posi = max;
            }
        }
        return jump;
    }

    public int jumpUsingDynamicProgramming(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(j+nums[j]>=i){
                    dp[i]=Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }

}
