package Greedy;

public class NumberOfGoodPairs {

    public static void main(String[] args) {
        int nums[] = {1,2,3,1,1,3};
        Solution_NumberOfGoodPairs solution = new Solution_NumberOfGoodPairs();
        System.out.println(solution.numIdenticalPairs(nums));
    }

}

class Solution_NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        int[] freq = new int[101];
        for(int i: nums) {
            freq[i]++;
            if(freq[i]>0) {
                ans+=(freq[i]-1);
            }
        }
        return ans;
    }
}
