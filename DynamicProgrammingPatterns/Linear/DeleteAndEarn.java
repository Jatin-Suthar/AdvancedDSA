package DynamicProgrammingPatterns.Linear;

import java.util.*;

public class DeleteAndEarn {

    public static void main(String[] args) {
        DeleteAndEarnSolution solution = new DeleteAndEarnSolution();
        System.out.println(solution.deleteAndEarn(new int[] {3,1}));
    }

}

class DeleteAndEarnSolution {
    public int deleteAndEarnItr(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num] += num;
        }
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = count[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + count[i]);
        }
        return dp[max];
    }
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+num);
        }
        List<Pair> pairs = new ArrayList<>();
        for(int num: map.keySet()) pairs.add(new Pair(num, map.get(num)));
        int[] dp = new int[pairs.size() + 1];
        dp[0] = 0;
        dp[1] = pairs.get(0).sum;
        for (int i = 2; i <= pairs.size(); i++) {
            if(pairs.get(i-1).val+1==pairs.get(i-2).val) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + pairs.get(i - 1).sum);
            } else {
                dp[i] = dp[i - 1] + pairs.get(i - 1).sum;
            }
        }
        return dp[pairs.size()];
    }
}

class Pair {
    int val;
    int sum;
    public Pair(int val, int sum) {
        this.val = val;
        this.sum = sum;
    }
}