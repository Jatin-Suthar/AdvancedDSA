package DynamicProgramming;

public class TwoKeysKeyboard {
	public static void main(String[] args) {
		int n = 16;
		System.out.println(minSteps(n));
	}
	public static int minSteps(int n) {
        int dp[] = new int[n+1];
        for(int i=2; i<=n; i++) {
            dp[i]=i;
            for(int j=i/2; j>1; j--) {
                if(i%j==0) {
                    dp[i] = dp[j] + dp[i/j];
                }
            }
        }
        return dp[n];
    }
}
