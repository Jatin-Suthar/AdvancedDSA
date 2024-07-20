package Strings;

public class LongestPallindromicSubstring {

    public String longestPalindrome(String s) {
        int max = 0, n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for(int k=0; k<n; k++) {
            for(int i=0, j=k; j<n; i++, j++) {
                if(k==0) {
                    dp[i][j]=true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if(k==1) {
                        if(b) {
                            dp[i][j]=true;
                        }
                    } else {
                        if(b && dp[i+1][j-1]) {
                            dp[i][j]=true;
                        }
                    }
                }
                if(dp[i][j]) {
                    String temp = s.substring(i, j+1);
                    if(temp.length()>max) {
                        max = temp.length();
                        res = temp;
                    }
                }
            }
        }
        return res;
    }

    public String longestPalindromeOptimized(String s) {
        String longest = "";
        int maxLen = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Check for odd-length palindromes
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > maxLen) {
                maxLen = oddPalindrome.length();
                longest = oddPalindrome;
            }

            // Check for even-length palindromes
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (evenPalindrome.length() > maxLen) {
                maxLen = evenPalindrome.length();
                longest = evenPalindrome;
            }
        }

        return longest;
    }

    private String expandAroundCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

}

