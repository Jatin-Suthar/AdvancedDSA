package DynamicProgramming;

import java.util.Scanner;

public class NthFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(nthFibonacci(sc.nextInt()));
    }
    static int MOD = 1000000007;
    static int nthFibonacci(int n){
        return dfs(n, new int[n+1]);
    }
    static int dfs(int n, int[] dp){
        if(n==1 || n==2) return 1;
        if(dp[n]!=0)
            return dp[n];
        return dp[n] = (dfs(n-1, dp)+dfs(n-2, dp))%MOD;
    }
}
