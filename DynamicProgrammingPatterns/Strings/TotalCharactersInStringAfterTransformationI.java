package DynamicProgrammingPatterns.Strings;

public class TotalCharactersInStringAfterTransformationI {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthAfterTransformations("abcyy", 2));
    }
    static class Solution {
        final int MOD = 1_000_000_007;
        public int lengthAfterTransformationsDP(String s, int t) {
            int[] dp = new int[t + 26];
            for(int i=0; i<26; i++) {
                dp[i] = 1;
            }

            for(int i=26; i<t+26; i++) {
                dp[i] = (dp[i-26] + dp[i-25])%MOD;
            }

            int ans = 0;
            for(char c: s.toCharArray()) {
                ans = (ans + dp[c-'a'+t])%MOD;
            }
            return ans;
        }
        public int lengthAfterTransformations(String s, int t) {
            long[] freq = new long[26];
            for(char c: s.toCharArray()) {
                freq[c-'a']++;
            }
            while(t>=26) {
                long[] newFreq = new long[26];
                for(int i=0; i<26; i++) {
                    if(freq[i] > 0) {
                        newFreq[i] = (newFreq[i] + freq[i])%MOD;
                        if (i == 25) {
                            newFreq[0] = (newFreq[0] + freq[i])%MOD;
                            newFreq[1] = (newFreq[1] + freq[i])%MOD;
                        } else {
                            newFreq[i + 1] = (newFreq[i+1] + freq[i])%MOD;
                        }
                    }
                }
                freq = newFreq;
                t -= 26;
            }
            long count = 0;
            for(int i=0; i<26; i++) {
                if(26-i <= t) {
                    count = (count + (2*freq[i])%MOD)%MOD;
                } else {
                    count = (count + freq[i])%MOD;
                }
            }
            return (int) count;
        }
    }

/*

any single char to make it double char, it will take : 26 - (c-'a') transformations

a -> ab : 26 steps -> 1 char -> max 26 stpes -> 2 chars
b -> ab : 25 steps
.
.
.
.
z -> ab : 1 steps
     .
     .
     .
     .


*/
}
