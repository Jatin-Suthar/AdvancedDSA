package SlidingWindow;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int[] arr = {1,0,0,0};
        int k = 2;
        MaxConsecutiveOnesIIISolution solution = new MaxConsecutiveOnesIIISolution();
        System.out.println(solution.longestOnes(arr, k));
    }

}

class MaxConsecutiveOnesIIISolution {
    public int longestOnes(int[] nums, int k) {
        int max = 0, left = 0, right = 0;
        for (int num : nums) {
            if (num == 1) {
                right++;
            } else {
                if (k > 0) {
                    k--;
                    right++;
                } else {
                    max = Math.max(max, right - left);
                    while (left < nums.length && nums[left] == 1) {
                        left++;
                    }
                    left++;
                    right++;
                }
            }
        }
        return Math.max(max, right-left);
    }
}