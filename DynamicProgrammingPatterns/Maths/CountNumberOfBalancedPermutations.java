package DynamicProgrammingPatterns.Maths;

public class CountNumberOfBalancedPermutations {
    public static void main(String[] args) {
        String str = "123";
        Solution solution = new Solution();
        System.out.println(solution.countBalancedPermutations(str));
    }
    static class Solution {
        int n, totalSum = 0, totalPermutationSum;
        final int MOD = 1_000_000_007;
        Integer[][][] dp;
        public int countBalancedPermutations(String str) {
            //initialize freq arr
            int[] freq = new int[10];
            n = str.length();

            //compute frequency
            for (char c : str.toCharArray()) {
                int digit = c - '0';
                freq[digit]++;
                totalSum += digit;
            }

            //return 0 if total sum is odd
            if((totalSum&1)==1) return 0;

            //precompute factorial
            long[] fact = new long[n+1];
            fact[0] = 1;
            fact[1] = 1;
            for(int i=2; i<=n; i++) {
                fact[i] = (i*fact[i-1])%MOD;
            }
            //precompute inverse factorial using Ferment logic
            long[] invFact = new long[n+1];
            for(int i=0; i<=n; i++) {
                invFact[i] = findPower(fact[i], MOD-2);
            }

            totalPermutationSum = (int)((fact[(n + 1) / 2] * fact[n / 2]) % MOD);

            int halfSum = totalSum/2;
            int evenLength = (n+1)/2;

            dp = new Integer[10][evenLength+1][halfSum+1];

            return solve(freq, 0, halfSum, evenLength, invFact);
        }

        private long findPower(long num, int n) {
            if(n==1) return num;
            long ans;
            long power = findPower(num, n/2);
            ans = (power * power)%MOD;
            if((n&1) == 1) {
                ans = (ans*num)%MOD;
            }
            return ans;
        }

        private int solve(int[] freq, int digit, int remainingSum, int remainingLen, long[] invFact) {
            if(digit == 10) {
                if(remainingLen == 0 && remainingSum == 0) return totalPermutationSum;
                return 0;
            }

            if(dp[digit][remainingLen][remainingSum]!=null) return dp[digit][remainingLen][remainingSum];

            int ways = 0;
            int maxTake = Math.min(freq[digit], remainingLen);
            for (int i = 0; i <= maxTake; i++) {
                int newSum = remainingSum - (digit * i);
                if(newSum < 0) break;
                int div = solve(freq, digit + 1, newSum,
                        remainingLen - i, invFact);
                int oddDigit  = freq[digit]- i;
                long val = (invFact[i]*invFact[oddDigit])%MOD;
                ways = (int) ((ways + (div * val)%MOD)%MOD);
            }

            return dp[digit][remainingLen][remainingSum] = ways;
        }
    }
}
