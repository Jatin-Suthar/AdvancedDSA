package Hashing;

public class MaximumManhattanDistanceAfterKChanges {
    public static void main(String[] args) {
        System.out.println(new Solution().maxDistance("NWSE", 1));
    }
    static class Solution {
        public int maxDistance(String s, int k) {
            int[] freq = new int[4];
            for(char c: s.toCharArray()) {
                if(c=='N') freq[0]++;
                if(c=='E') freq[1]++;
                if(c=='S') freq[2]++;
                if(c=='W') freq[3]++;
            }
            return Math.max(findDiff(freq, 'x', k), findDiff(freq, 'y', k));
        }
        public int findDiff(int[] freq, char dir, int carry) {
            int i=0, j=2, m=1, n=3;
            if(dir!='x') {
                m=0; n=2; i=1; j=3;
            }
            return maxDiff(freq, i, j, m, n, carry);
        }
        public int maxDiff(int[] freq, int i, int j, int m, int n, int carry) {
            int xDiff = Math.abs(freq[i]-freq[j]);
            int xMin = Math.min(freq[i], freq[j]);
            if(xMin <= carry) {
                xDiff += (xMin*2);
                carry -= xMin;
            } else {
                xDiff += (carry*2);
                carry = 0;
            }
            return xDiff + Math.abs(freq[m]-freq[n]) + Math.min(Math.min(freq[m], freq[n])*2, carry*2);
        }
    }
}
