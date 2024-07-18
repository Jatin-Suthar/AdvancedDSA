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
                } else if(k==1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j]=true;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                        dp[i][j]=true;
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

}

