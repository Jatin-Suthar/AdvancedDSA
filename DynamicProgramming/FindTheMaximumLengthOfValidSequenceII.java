package DynamicProgramming;

public class FindTheMaximumLengthOfValidSequenceII {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumLength(new int[] {1,2,3,4,5}, 2));
    }
    static class Solution {
        Integer[][][] dp;
        public int maximumLength(int[] nums, int k) {
            int n = nums.length;
            if(n==2) return 2;
            dp = new Integer[n][k+1][k+1];
            return recur(nums, k, 0, k, k);
        }
        public int recur(int[] arr, int k, int idx, int prev, int lastPrev) {
            if(idx >= arr.length) return 0;
            if(dp[idx][prev][lastPrev]!=null) return dp[idx][prev][lastPrev];
            int max = 0;
            if(lastPrev!=k && lastPrev == arr[idx]%k) {
                max = 1+recur(arr, k, idx+1, arr[idx]%k, prev);
            } else if(prev == k || lastPrev == k) {
                if(prev==k) {
                    max = 1+recur(arr, k, idx+1, arr[idx]%k, lastPrev);
                } else {
                    max = 1+recur(arr, k, idx+1, arr[idx]%k, prev);
                }
            }
            return dp[idx][prev][lastPrev] = Math.max(max, recur(arr, k, idx+1, prev, lastPrev));
        }
    }
/**

 [3,4,6]
 [0,1,0]


 */
}
