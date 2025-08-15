package Greedy;

import java.util.Objects;

public class LexicographicallyLargest {
    public static void main(String[] args) {
        String s = "dbca";
        int t = 2;
        System.out.println(new Solution().answerString(s, t));
    }
    static class Solution {
        public String answerString(String word, int numFriends) {
            int n = word.length();
            int window = n - numFriends + 1;
            int st = 0;
            String ans = null;
            for(int ed=0; ed<n; ed++) {
                if(ed-st >= window) {
                    String subStr = word.substring(st, ed);
                    if(ans == null || ans.equals(subStr)) ans = subStr;
                    else {
                        ans = lexicographicallyGreater(ans, word.substring(st, ed));
                    }
                    st++;
                }
            }
            return ans;
        }
        public String lexicographicallyGreater(String s, String t) {
            int i=0;
            while(s.charAt(i)==t.charAt(i)) i++;
            return (s.charAt(i) < t.charAt(i)) ? s : t;
        }
    }
}
