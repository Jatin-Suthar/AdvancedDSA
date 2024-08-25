package DynamicProgrammingPatterns.Linear;

public class IntegerBreak {

    public static void main(String[] args) {
        IntegerBreakSolution solution = new IntegerBreakSolution();
        System.out.println(solution.integerBreak(5));
    }

}

class IntegerBreakSolution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            for(int j=1; j<i; j++) {
                dp[i] = Math.max(dp[i], j*dp[i-j]);
            }
        }
        return dp[n];
    }
}