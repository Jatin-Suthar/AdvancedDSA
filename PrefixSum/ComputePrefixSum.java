package PrefixSum;

import java.util.Arrays;

public class ComputePrefixSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ComputePrefixSumSolution solution = new ComputePrefixSumSolution();
        System.out.println(Arrays.toString(solution.computePrefixSum(arr)));
    }

}

class ComputePrefixSumSolution {
    public int[] computePrefixSum(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        return prefixSum;
    }
}