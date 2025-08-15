package Maths;

public class MaxDifferenceYouGetByChangingIntegers {
    public static void main(String[] args) {
        System.out.println(new Solution().maxDiff(555));
    }
    static class Solution {
        public int maxDiff(int num) {
            return remap(num, 9) - remap(num, 1);
        }
        public int remap(int n, int i) {
            int num = n, ans = 0;
            int t = n, replace = i;
            if(i==1) {
                int len = (int)Math.log10(n);
                int first = (int) (n/Math.pow(10, len));
                if(first != 1) {
                    replace = first;
                } else {
                    i = 0;
                    while(t>=10) {
                        int rem = t%10;
                        if(rem != i && rem!=first) {
                            replace = rem;
                        }
                        t/=10;
                    }
                }
            } else {
                while(t>0) {
                    int rem = t%10;
                    if(rem != i) {
                        replace = rem;
                    }
                    t /= 10;
                }
            }
            int place = 1;
            while(num > 0) {
                int rem = num%10;
                if(rem == replace) rem = i;
                ans += (rem * place);
                place *= 10;
                num /= 10;
            }
            return ans;
        }
    }
}
