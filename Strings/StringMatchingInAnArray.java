package Strings;

import java.util.*;

public class StringMatchingInAnArray {

    public static void main(String[] args) {
        String[] words = {"leetcode", "eet", "code"};
        StringMatchingInAnArraySolution solution = new StringMatchingInAnArraySolution();
        System.out.println(solution.stringMatching(words));
    }

}

class StringMatchingInAnArraySolution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].length() >= words[i].length() && kmpMatch(words[j], words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    private boolean kmpMatch(String s, String t) {
        int n = t.length();
        int[] lps = new int[n];
        computeLPSArray(t, lps);

        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
            if (j == t.length()) {
                return true;
            }
        }
        return false;
    }

    private void computeLPSArray(String t, int[] lps) {
        int length = 0;
        int i = 1;
        lps[0] = 0;

        while (i < t.length()) {
            if (t.charAt(i) == t.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
