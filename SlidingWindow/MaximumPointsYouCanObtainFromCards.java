package SlidingWindow;

public class MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {

        int[] cardPoints = {9,7,7,9,7,7,9};
        int k = 6;
        MaximumPointsYouCanObtainFromCardsSolution solution = new MaximumPointsYouCanObtainFromCardsSolution();
        System.out.println(solution.maxScore(cardPoints, k));

    }

}

class MaximumPointsYouCanObtainFromCardsSolution {
    public int maxScore(int[] nums, int k) {
        int s = 0, n = nums.length, sum = 0, ans = 0;
        for(int num: nums) sum += num;
        if(n==k) return sum;
        for(int e = 0; e < n; e++) {
            sum -= nums[e];
            if((e-s+1) == n-k) {
                ans = Math.max(ans, sum);
                sum += nums[s];
                s++;
            }
        }
        return ans;
    }
}
