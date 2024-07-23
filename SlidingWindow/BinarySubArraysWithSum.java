package SlidingWindow;

public class BinarySubArraysWithSum {

    public static void main(String[] args) {

        int[] nums = {1,0,1,0,1};
        int goal = 2;
        BinarySubArraysWithSumSolution solution = new BinarySubArraysWithSumSolution();
        System.out.println(solution.numSubarraysWithSum(nums, goal));

    }

}

class BinarySubArraysWithSumSolution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubarraysWithSum(nums, goal)-countSubarraysWithSum(nums, goal-1);
    }
    public int countSubarraysWithSum(int[] nums, int goal) {
        if(goal<0) return 0;
        int n = nums.length, s = 0, count = 0, sum = 0;
        for(int e=0; e<n; e++) {
            sum += nums[e];
            while(sum>goal) {
                sum -= nums[s++];
            }
            count += (e-s+1);
        }
        return count;
    }
}