package MonotonicStack;

import java.util.*;

public class RobotWithPrintingString {
    public static void main(String[] args) {
        System.out.println(new Solution().robotWithString("vzhofnpo"));
    }
    static class Solution {
        public String robotWithString(String s) {
            int[] freq = new int[26];
            for(char c: s.toCharArray()) {
                freq[c]++;
            }
            StringBuilder sb = new StringBuilder();
            Deque<Character> stack = new ArrayDeque<>();
            for(char c: s.toCharArray()) {
                stack.push(c);
                freq[c-'a']--;
                int smallest = 0;
                while(smallest < 26 && freq[smallest] == 0) smallest++;
                while(!stack.isEmpty() && (stack.peek()-'a') <= smallest) {
                    sb.append(stack.pop());
                }
            }
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }
    }
}
