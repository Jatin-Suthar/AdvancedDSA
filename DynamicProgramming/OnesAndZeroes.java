package DynamicProgramming;

public class OnesAndZeroes {
	public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m + 1][n + 1][strs.length + 1];
        return helper(strs, m, n, 0, dp);
    }
    public int helper(String a[], int m, int n, int start, int[][][] dp) {
        if (start > a.length - 1) return 0;
        if(m==0 && n==0) return 0;
        if(m<0 || n<0) return 0;
        if(dp[m][n][start]!=0) return dp[m][n][start];
        
        int[] count = countZerosAndOnes(a[start]);
        if(count[0]<=m && count[1]<=n) {
            return dp[m][n][start] = Math.max(helper(a, m, n, start+1, dp), 1+helper(a, m-count[0], n-count[1], start+1, dp));
        } 
        return dp[m][n][start] = helper(a, m, n, start+1, dp);
    }
    public int[] countZerosAndOnes(String s) {
        int i=0; int j=0;
        for(char c: s.toCharArray()) {
            if(c=='0') i++;
            else j++;
        }
        return new int[] {i, j};
    }
}
