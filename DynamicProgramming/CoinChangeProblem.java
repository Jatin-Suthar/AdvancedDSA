package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChangeProblem {
	public static void main(String[] args) {
		int[] a={3,7,405,436};
		int target=8839;
		System.out.println(coinChange(a, target));
	}
	static Map<Integer, Integer> map = new HashMap<>();
	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		return helper(coins, amount);
    }
    public static int helper(int[] coin, int amount) {
    	int dp[] = new int[amount+1];
    	Arrays.fill(dp, -1);
    	dp[0]=0;
    	for(int i=coin[0]; i<=amount; i++) {
    		int ans = 100000;
    		for(int j: coin) {
    			int rem = i-j;
    			if(rem<0) continue;
    			ans = Math.min(ans, 1+dp[rem]);
    		}
    		dp[i]=ans;
    	}
    	return dp[amount];
    }
}
