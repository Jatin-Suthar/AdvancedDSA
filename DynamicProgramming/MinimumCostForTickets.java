package DynamicProgramming;

import java.util.Arrays;

public class MinimumCostForTickets {
	public static void main(String[] args) {
		int[] days = {1,4,6,7,8,20};
		int[] costs = {2,7,15};
		Solution1 sol = new Solution1();
		System.out.println(sol.mincostTickets(days, costs));
	}
}

class Solution1 {
	int dp[];
	public int mincostTickets(int[] days, int[] costs) {
        //days = [1,4,6,7,8,20], costs = [2,7,15]
		int daysLen = days.length; int costsLen = costs.length;
		dp = new int[days[daysLen-1]+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		return helper(days, costs, days[0], 0, daysLen, costsLen);
    }

	private int helper(int[] days, int[] costs, int traveled, int idx, int daysLen, int costsLen) {
		while(idx<daysLen && traveled>days[idx]) {
			idx++;
		}
		if(idx>=daysLen) return 0;
		traveled = days[idx];
		if(dp[days[idx]]!=Integer.MAX_VALUE) return dp[days[idx]];
		return dp[days[idx]] = Math.min(helper(days, costs, traveled + 1, idx, daysLen, costsLen) + costs[0], 
							   Math.min(helper(days, costs, traveled + 7, idx, daysLen, costsLen) + costs[1],
							   			helper(days, costs, traveled + 30, idx, daysLen, costsLen) + costs[2]));
	}
}
