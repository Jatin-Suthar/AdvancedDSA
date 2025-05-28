package Strings;

public class KmpStringMatching {
}

class KmpStringMatchingSolution {
    public int findFirstIdx(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        int[] lps = buildLps(pattern);
        int i=0, j=0;
        while(i<n) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if(j>=m) {
                return i-j;
            } else if(i<n && text.charAt(i) != pattern.charAt(j)){
                if(j!=0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
    public int[] buildLps(String pattern) {
        int len = 0, i = 1, n = pattern.length();
        int[] lps = new int[n];
        while(i<n) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len!=0) {
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}