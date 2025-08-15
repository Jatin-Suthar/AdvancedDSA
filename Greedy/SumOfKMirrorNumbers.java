package Greedy;

import java.util.*;

public class SumOfKMirrorNumbers {
    public static void main(String[] args) {
        System.out.println(new Solution().kMirror(7, 40));
    }

    static class Solution {
        int count = 0;
        long sum = 0;

        public long kMirror(int k, int n) {
            int len = 1;
            while (count < n) {
                generate("", len, k, n);
                len++;
            }
            return sum;
        }

        void generate(String half, int len, int k, int n) {
            if (count >= n) return;

            if (half.length() == (len + 1) / 2) {
                String mirror = new StringBuilder(half.substring(0, len % 2 == 0 ? half.length() : half.length() - 1)).reverse().toString();
                String full = half + mirror;
                long num = Long.parseLong(full);

                if (isBasePalindrome(num, k)) {
                    sum += num;
                    count++;
                }
                return;
            }

            char start = half.isEmpty() ? '1' : '0';
            for (char c = start; c <= '9'; c++) {
                generate(half + c, len, k, n);
                if (count >= n) return;
            }
        }

        public boolean isBasePalindrome(long n, int k) {
            long a = 0, b = 0;
            long pow = 1;
            while (n > 0) {
                long rem = n % k;
                a = a * 10 + rem;
                b = rem * pow + b;
                pow *= 10;
                n /= k;
            }
            return a == b;
        }
    }
}