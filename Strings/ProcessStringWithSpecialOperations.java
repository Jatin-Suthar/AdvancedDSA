package Strings;

/**
 * You are given a string s consisting of lowercase English letters and the special characters: *, #, and %.
 * <p>
 * Build a new string result by processing s according to the following rules from left to right:
 * <p>
 * If the letter is a lowercase English letter append it to result.
 * A '*' removes the last character from result, if it exists.
 * A '#' duplicates the current result and appends it to itself.
 * A '%' reverses the current result.
 * Return the final string result after processing all characters in s.
 */

public class ProcessStringWithSpecialOperations {
    public static void main(String[] args) {
        System.out.println(new Solution().processStr("*%"));
    }
    static class Solution {
        public String processStr(String s) {
            StringBuilder sb = new StringBuilder();
            for(char c: s.toCharArray()) {
                switch (c) {
                    case '#':
                        sb.append(sb);
                        break;
                    case '*':
                        if(!sb.isEmpty()) {
                            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
                        }
                        break;
                    case '%':
                        sb.reverse();
                        break;
                    default:
                        sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
