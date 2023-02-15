package DynamicProgramming;

public class MatrixSquare {
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},
				           {'1','0','1','1','1'},
				           {'1','1','1','1','1'},
				           {'1','0','0','1','0'}};
		System.out.println(maximalSquare(matrix));
	}
	public static int maximalSquare(char[][] matrix) {
		if(matrix.length==0 || matrix[0].length==0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int max=0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(matrix[i-1][j-1]=='1') {
                    dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
