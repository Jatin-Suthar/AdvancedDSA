package SlidingWindow;

public class ReplaceTheSubstringForBalancedString {
    public static void main(String[] args) {
        String s = "QQQW";
        Solution solution = new Solution();
        System.out.println(solution.balancedString(s));
    }
    static class Solution {
        public int balancedString(String s) {
            int n = s.length();
            int target = n / 4;
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'A']++;
            }

            if (count['Q' - 'A'] == target &&
                    count['W' - 'A'] == target &&
                    count['E' - 'A'] == target &&
                    count['R' - 'A'] == target) {
                return 0;
            }

            int minLen = n;
            int left = 0;
            for (int right = 0; right < n; right++) {
                count[s.charAt(right) - 'A']--;

                while (left <= right &&
                        count['Q' - 'A'] <= target &&
                        count['W' - 'A'] <= target &&
                        count['E' - 'A'] <= target &&
                        count['R' - 'A'] <= target) {
                    minLen = Math.min(minLen, right - left + 1);
                    count[s.charAt(left++) - 'A']++;
                }
            }

            return minLen;
        }
    }
}

/*


*/