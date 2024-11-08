package PrefixSum;

public class MinOperationToReduceXtoZero {
}

class MinOperationToReduceXtoZeroSolution {
    public int minOperations(int[] nums, int x) {
        int pSum = -x, n = nums.length;
        for(int num: nums) pSum += num;
        if(pSum == 0) return n;
        int sum = 0, maxLen = 0, left = 0, right=0;
        for(; right<n; right++) {
            sum += nums[right];
            while(left <= right && sum >= pSum) {
                if(sum == pSum)
                    maxLen = Math.max(maxLen, right-left+1);
                sum -= nums[left++];
            }
        }
        return (maxLen == 0) ? -1 : n - maxLen;
    }
}
/*

[3,2,20,1,1,3]

30 - 10 = 20

[3, 5, 25, ]

max -> 1

Sum(nums) - x

[3,2,20,1,1,3]
[3,5,25,26,27,30]
[30,27,25,5,4,3]

20

[
    0 -> -1,
    3 -> 0,
    5 -> 1,
    25 -> 2,
    26 -> 3,
    27 -> 4,
    30 -> 5
]

*/