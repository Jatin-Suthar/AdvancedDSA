package DynamicProgramming;

public class LastStoneWeightII {
	public static void main(String[] args) {
		
	}
}

class Solution2 {
	Integer dp[][];
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int val: stones) sum+=val;
        int target = sum>>1;
        dp = new Integer[stones.length+1][target+1];
        return Math.abs(sum-2*(helper(stones, 0, 0, target)));
    }
    public int helper(int[] stones, int idx, int sum, int target) {
        if(idx>=stones.length) return sum;
        if(dp[idx][sum]!=null) return dp[idx][sum];
        if(stones[idx]+sum>target) {
            return dp[idx][sum]=helper(stones, idx+1, sum, target);
        } else {
            return dp[idx][sum]=Math.max(helper(stones, idx+1, sum+stones[idx], target), helper(stones, idx+1, sum, target));
        }
    }
}
