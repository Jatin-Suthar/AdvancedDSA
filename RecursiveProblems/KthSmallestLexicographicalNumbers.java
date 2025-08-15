package RecursiveProblems;

public class KthSmallestLexicographicalNumbers {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthNumber(13, 2));
    }
    static class Solution {
        public int findKthNumber(int n, int k) {
            return recur(0, n, k);
        }
        public int recur(int curr, int n, int k) {
            if(k == 0) return curr;
            int ans = -1;
            for(int i=0; i<10; i++) {
                if(curr == 0 && i==0) continue;
                ans = Math.max(ans, recur(curr*10 + i, n, k-1));
                if(ans != -1) return ans;
            }
            return ans;
        }
    }
}
