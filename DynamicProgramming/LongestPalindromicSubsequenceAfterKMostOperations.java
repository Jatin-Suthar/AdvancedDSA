package DynamicProgramming;

import java.util.*;

public class LongestPalindromicSubsequenceAfterKMostOperations {
    public static void main(String[] args) {
        String s = "abced";
        int k = 2;
        LongestPalindromicSubsequenceAfterKMostOperationsSolution solution
                = new LongestPalindromicSubsequenceAfterKMostOperationsSolution();
        System.out.println(solution.longestPalindromicSubsequence(s, k));
    }
}
class LongestPalindromicSubsequenceAfterKMostOperationsSolution {
    Map<String, Integer> map = new HashMap<>();
    public int longestPalindromicSubsequence(String s, int k) {
        int n = s.length();
        return recur(s, "", n-1, k);
    }
    public int recur(String s, String temp, int n, int k) {
        if(n<0) {
            if (isPalindrome(temp)) {
                return temp.length();
            }
            return 0;
        }
        String key = temp + n;
        if(map.get(key)!=null) return map.get(key);
        char curr = s.charAt(n);
        char prev = (curr=='a') ? 'z' : (char)(curr-1);
        char next = (curr=='z') ? 'a' : (char)(curr+1);
        int pickNbr = 0;
        if(k>0) {
            pickNbr = Math.max(recur(s, prev + temp, n - 1, k-1),
                               recur(s, next + temp, n - 1, k-1));
        }
        int pick = recur(s, curr + temp, n-1, k);
        int notPick = recur(s, temp, n-1, k);
        int ans = Math.max(Math.max(pickNbr, pick), notPick);
        map.put(key, ans);
        return ans;
    }

    private boolean isPalindrome(String temp) {
        int st = 0, ed = temp.length()-1;
        while(st<ed) {
            if(temp.charAt(st++)!=temp.charAt(ed--)) return false;
        }
        return true;
    }
}

/*

abced



*/