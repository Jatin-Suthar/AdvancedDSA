package DynamicProgrammingPatterns.BitMasking;

import java.util.*;

public class ConcatenatedDivisibility {
    public static void main(String[] args) {
        int[] nums = {3,12,45};
        int k = 5;
        ConcatenatedDivisibilitySolution solution = new ConcatenatedDivisibilitySolution();
        System.out.println(Arrays.toString(solution.concatenatedDivisibility(nums, k)));
    }
}

class ConcatenatedDivisibilitySolution {
    public int[] concatenatedDivisibility(int[] nums, int k) {
        int n = nums.length;
        int[] lengths = new int[n];

        // Precompute powers of 10 modulo k for each number
        for (int i = 0; i < n; i++) {
            lengths[i] = (int) Math.log10(nums[i]) + 1;
        }

        // dp[mask][rem] = best lexicographical sequence
        Map<Integer, Map<Integer, List<Integer>>> dp = new HashMap<>();

        List<Integer> result = dfs(nums, k, 0, 0, lengths, dp);
        if (result == null) return new int[0];
        return result.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> dfs(int[] nums, int k, int mask, int rem, int[] lengths,
                              Map<Integer, Map<Integer, List<Integer>>> dp) {
        if (mask == (1 << nums.length) - 1) {
            return rem == 0 ? new ArrayList<>() : null;
        }

        if (dp.containsKey(mask) && dp.get(mask).containsKey(rem)) {
            return dp.get(mask).get(rem);
        }

        List<Integer> best = null;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) == 0) {
                int num = nums[i];
                int len = lengths[i];
                int newRem = (rem * modPow10(len, k) + num) % k;
                List<Integer> sub = dfs(nums, k, mask | (1 << i), newRem, lengths, dp);
                if (sub != null) {
                    List<Integer> candidate = new ArrayList<>();
                    candidate.add(num);
                    candidate.addAll(sub);

                    if (best == null || compare(candidate, best) < 0) {
                        best = candidate;
                    }
                }
            }
        }

        dp.computeIfAbsent(mask, m -> new HashMap<>()).put(rem, best);
        return best;
    }

    private int modPow10(int exp, int mod) {
        int res = 1;
        int base = 10;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    private int compare(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) - b.get(i);
            }
        }
        return a.size() - b.size();
    }
}
