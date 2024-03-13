package Greedy;

public class Pattern {

    public static void main(String[] args) {
        int[] nums = {3,1,4,2};
        Solution_Pattern solution = new Solution_Pattern();
        System.out.println(solution.find132pattern(nums));
    }

}
/*
        Example 1:

        Input: nums = [1,2,3,4]
                         a b c
        Output: false
        Explanation: There is no 132 pattern in the sequence.

        Example 2:

        Input: nums = [3,1,4,2]
        Output: true
        Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

        Example 3:

        Input: nums = [-1,3,2,0]
        Output: true
        Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
*/
class Solution_Pattern {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if(len <= 2) return false;
        int a = 0;
        while(a<len-2) {
            int b = a+1;
            while(b<len-1) {
                int c = b+1;
                while(c<len) {
                    if(nums[a] < nums[b] && nums[b] > nums[c]) return true;
                    c++;
                }
                b++;
            }
            a++;
        }
        return false;
    }
}