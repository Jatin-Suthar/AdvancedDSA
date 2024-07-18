package DynamicProgramming;

public class CombinationNCR {

    static int MOD = 1000000007;

    static int nCr(int n, int r) {
        if (r > n) return 0;
        if (r == n || r == 0) return 1;

        long[] dp = new long[n + 1];
        fillDp(n, dp);

        long numerator = dp[n];
        long denominator = (dp[r] * dp[n - r]) % MOD;

        return (int) (numerator * modInverse(denominator, MOD) % MOD);
    }

    static long fillDp(int n, long[] dp) {
        if (n == 0) return 1;
        if (dp[n] != 0) return dp[n];

        dp[n] = (n * fillDp(n - 1, dp)) % MOD;
        return dp[n];
    }

    static long modInverse(long a, int m) {
        return modPow(a, m - 2, m);
    }

    static long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

}
