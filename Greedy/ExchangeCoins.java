package Greedy;

import java.util.*;

public class ExchangeCoins {

    public static void main(String[] args) {
        SolutionExchangeCoins sol = new SolutionExchangeCoins();
        int target=11;
        int len=4;
        int[] ele = {9, 6, 5, 1};
        System.out.println(sol.minCoins(ele, len, target));
    }

}

class SolutionExchangeCoins {
    int ans = 0;
    boolean valid=false;
    public int minCoins(int coins[], int M, int V)
    {
        Arrays.sort(coins);
        recur(coins, M-1, V, 0);
        return (valid) ? ans : -1;
    }

    public void recur(int nums[], int idx, int target, int sum) {
        if(target==0) {
            if(!valid) ans = sum;
            else ans = Math.min(ans, sum);
            valid=true;
            return;
        }
        if(idx==-1) return;
        int org = target;
        int mul = target/nums[idx];
        target %= nums[idx];
        recur(nums, idx-1, target, sum+mul);
        recur(nums, idx-1, org, sum);
    }
}