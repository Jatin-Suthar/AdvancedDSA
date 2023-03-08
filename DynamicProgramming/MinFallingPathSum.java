package DynamicProgramming;

import java.util.Arrays;

public class MinFallingPathSum {
	public static void main(String[] arsg) {
		
	}
}

class Solution {
	int dp[][];
	public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        dp = new int[len+1][len+1];
        for(int i=0; i<len; i++) {
        	Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<len; i++) {
        	ans = Math.min(ans, helper(matrix, 0, i, len));
        }
        return ans;
    }
	private int helper(int[][] matrix, int i, int j, int len) {
		if(i<0 || j<0 || i>=len || j>=len) return Integer.MAX_VALUE;
		if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
		if(i==len-1) {
			return dp[i][j] = matrix[i][j];
		}
		return dp[i][j] = Math.min(helper(matrix, i+1, j-1, len), Math.min(helper(matrix, i+1, j, len), helper(matrix, i+1, j+1, len)))+matrix[i][j];
	}
}
