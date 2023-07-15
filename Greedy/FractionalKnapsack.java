package Greedy;

import java.util.Comparator;
import java.util.Arrays;

public class FractionalKnapsack {

    public static void main(String[] args) {
        Item[] items = new Item[] { new Item(60, 60), new Item(60, 20), new Item(20, 20) };
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item item1, Item item2) {
                if (item1.weight != item2.weight) {
                    return Integer.compare(item1.weight, item2.weight);
                } else {
                    return Integer.compare(item2.value, item1.value);
                }
            }
        });
        Solution solution = new Solution();
        double ans = solution.fractionalKnapsack(50, items, items.length);
        System.out.println(ans);
    }

}


class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}


class Solution
{
    Double dp[][];
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        dp = new Double[W+1][n+1];
        return solve(arr, W, n, 0, 0);
    }

    public double solve(Item arr[], int W, int n, int idx, double sum) {
        if(idx==n || W==0) {
            return sum;
        }

        if(dp[W][idx]!=null) {
            return dp[W][idx];
        }

        double prevSum = sum;
        if(W-arr[idx].weight<=0) {
            double div = arr[idx].value/arr[idx].weight;
            sum += (div*W);
        } else {
            sum += arr[idx].value;
        }

        return dp[W][idx]=Math.max(solve(arr, W-arr[idx].weight, n, idx+1, sum),
                solve(arr, W, n, idx+1, prevSum));
    }
}