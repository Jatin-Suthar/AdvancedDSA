package DynamicProgrammingPatterns.Linear;

public class CountingBits {
}

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        int offset = 1;
        for(int i=1; i<=n; i++) {
            if(offset*2==i) {
                offset = i;
            }
            ans[i] = 1 + ans[i-offset];
        }
        return ans;
    }
}