package DynamicProgrammingPatterns.Strings;

import java.util.*;

public class PushDominoes {
    public static void main(String[] args) {
        String dominoes = "RR.L";
        Solution solution = new Solution();
        System.out.println(solution.pushDominoes(dominoes));
    }
    static class Solution {
        public String pushDominoes(String dominoes) {
            int n = dominoes.length();
            char[] nums = dominoes.toCharArray();
            int right = -1;
            for(int i=0; i<n; i++) {
                if(nums[i] == '.') continue;
                if(nums[i] == 'L') {
                    if(right == -1) {
                        int k=i-1;
                        while(k>=0 && nums[k]=='.') {
                            nums[k--] = 'L';
                        }
                    } else {
                        int lIdx = i;
                        int rIdx = right;
                        while(lIdx > rIdx) {
                            nums[lIdx--] = 'L';
                            nums[rIdx++] = 'R';
                        }
                        right = -1;
                    }
                } else {
                    if(right != -1) {
                        for(int k = right+1; k<i; k++) {
                            nums[k] = 'R';
                        }
                    }
                    right = i;
                }
            }
            if(right != -1) {
                for(int k = right+1; k<n; k++) {
                    nums[k] = 'R';
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char num : nums) {
                sb.append(num);
            }
            return sb.toString();
        }
    }

/*

01234567890123
.L.R...LR..L..

L: 1,7,11
R: 3,8

L: 1

...L..R...
..L.....L.
...R......

*/
}
