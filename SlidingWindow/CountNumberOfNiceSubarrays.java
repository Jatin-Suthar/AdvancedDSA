package SlidingWindow;

public class CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        CountNumberOfNiceSubarraysSolution solution = new CountNumberOfNiceSubarraysSolution();
        System.out.println(solution.numberOfSubarrays(nums, k));
    }

}

class CountNumberOfNiceSubarraysSolution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countSubarraysWithOdd(nums, k)-countSubarraysWithOdd(nums, k-1);
    }
    public int countSubarraysWithOdd(int[] nums, int k) {
        if(k<0) return 0;
        int n = nums.length, s = 0, count = 0, sum = 0;
        for(int e=0; e<n; e++) {
            sum += (nums[e]%2!=0) ? 1 : 0;
            while(sum>k) {
                if(nums[s++]%2!=0)
                    sum--;
            }
            count += (e-s+1);
        }
        return count;
    }
}