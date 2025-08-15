package Maths;

public class MaximumDistanceByRemappingDigits {
    public static void main(String[] args) {
        int num = 11891;
        System.out.println(new Solution().minMaxDifference(num));
    }
    static class Solution {
        public int minMaxDifference(int num) {
            return remap(num, 9) - remap(num, 0);
        }
        public int remap(int n, int i) {
            int num = n;
            int len = (int) Math.log10(num);
            double div = Math.pow(10, len);
            int first = (int)(num/div);
            int carry = 0, ans = 0;
            while(num > 0) {
                int rem = num%10;
                if(rem == 0) {
                    carry++;
                } else {
                    if(rem == first) {
                        rem = i;
                    }
                    if(carry > 0) {
                        rem = (int) (rem * Math.pow(10, carry));
                        carry = 0;
                    }
                    ans = rem*10 + ans;
                }
                num /= 10;
            }
            return ans/10;
        }
    }

/*

49034

4
30+4
34

*/
}
