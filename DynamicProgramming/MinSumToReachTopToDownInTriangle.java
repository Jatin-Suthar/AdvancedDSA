package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSumToReachTopToDownInTriangle {
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3,4));
		triangle.add(Arrays.asList(6,5,7));
		triangle.add(Arrays.asList(4,1,8,3));
		System.out.println(minimumTotal(triangle));
	}
	
	static int dp[][];
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        dp = new int[n][m];
        for(int i=0; i<n; i++) 
            for(int j=0; j<m; j++) 
                dp[i][j] = Integer.MAX_VALUE;
        
        return helper(triangle, 0, 0, 0, m, n);
    }
    public static int helper(List<List<Integer>> a, int i, int j, int sum, int m, int n) {
        if(i>=n || j>=m) return Integer.MAX_VALUE;
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int niche = helper(a, i+1, j, sum, m, n);
        int nicheseekage = helper(a, i+1, j+1, sum, m, n);
        if(Math.min(niche, nicheseekage)==Integer.MAX_VALUE) dp[i][j]=a.get(i).get(j);
        else dp[i][j] = Math.min(niche, nicheseekage)+a.get(i).get(j);
        return dp[i][j];
    }
}
