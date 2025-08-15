package DynamicProgramming;

public class FindTheMaximumOfValidSequenceI {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumLength(new int[] {1,2,1,1,2,1,2}));
    }
    static class Solution {
        Integer[][][] dp;
        public int maximumLength(int[] nums) {
            int n;
            int[] arr = new int[n = nums.length];
            if(n==2) return 2;
            dp = new Integer[n][3][3];
            for(int i=0; i<n; i++) arr[i] = nums[i]%2;
            return recur(arr, 0, 2, 2);
        }
        public int recur(int[] arr, int idx, int prev, int equal) {
            if(idx>=arr.length) return 0;
            if(dp[idx][prev][equal]!=null) return dp[idx][prev][equal];
            int max = 0;
            if(prev == 2) {
                max = 1+Math.max(recur(arr, idx+1, arr[idx], 1), recur(arr, idx+1, arr[idx], 0));
            } else {
                if(equal == 0) {
                    if (prev == 0 && arr[idx] == 1 || prev == 1 && arr[idx] == 0) {
                        max = 1 + recur(arr, idx + 1, arr[idx], equal);
                    }
                } else {
                    if (prev == arr[idx]) {
                        max = 1 + recur(arr, idx + 1, arr[idx], equal);
                    }
                }
            }
            return dp[idx][prev][equal] = Math.max(max, recur(arr, idx+1, prev, equal));
        }
    }

/*

[0,0,0]
[1,1,0,1,1]

[1,2,3,4]
[1,0,1,0]


[1,2,1,1,2,1,2]
[1,0,1,1,0,1,0]

*/
}
