package Maths;

import java.util.*;

public class CountOfTrapeZoids {
    public static void main(String[] args) {
        int[][] arr = {{1,0},{2,0},{3,0},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{2,2},{3,2}};
        System.out.println(new Solution().countTrapezoids(arr));
    }
    static class Solution {
        final int MOD = 1_000_000_007;
        final int MAX = 100_005;
        public int countTrapezoids(int[][] points) {
            Map<Integer, Integer> xAxis = new TreeMap<>();
            for(int[] point: points) {
                xAxis.put(point[1], xAxis.getOrDefault(point[1],0)+1);
            }
            List<Integer> xList = new ArrayList<>(xAxis.keySet());
            int n = xList.size();
            int ans = 0;
            CombinationsFast combinationFast = new CombinationsFast();
            combinationFast.precompute();
            for(int i=0; i<n-1; i++) {
                int x1 = xAxis.get(xList.get(i));
                for(int j=i+1; j<n; j++) {
                    int x2 = xAxis.get(xList.get(j));
                    if(x1 > 1 && x2 > 1) {
                        ans = (ans + (combinationFast.combination(x1, 2) * combinationFast.combination(x2, 2)))%MOD;
                    }
                }
            }
            return ans;
        }
    }

    static class CombinationsFast {
        final int MOD = 1_000_000_007;
        final int MAX = 100_005;
        long[] fact = new long[MAX];
        long[] invFact = new long[MAX];

        public void precompute() {
            fact[0] = invFact[0] = 1;
            for (int i = 1; i < MAX; i++) {
                fact[i] = (fact[i - 1] * i) % MOD;
            }
            invFact[MAX - 1] = modInverse(fact[MAX - 1]);
            for (int i = MAX - 2; i >= 1; i--) {
                invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
            }
        }

        public long modInverse(long a) {
            return power(a, MOD - 2);
        }

        public long power(long a, long b) {
            long res = 1;
            a %= MOD;
            while (b > 0) {
                if ((b & 1) == 1) res = (res * a) % MOD;
                a = (a * a) % MOD;
                b >>= 1;
            }
            return res;
        }

        public int combination(int n, int k) {
            if (k < 0 || k > n) return 0;
            return (int) (((fact[n] * invFact[k]) % MOD) * invFact[n - k]) % MOD;
        }
    }
}
