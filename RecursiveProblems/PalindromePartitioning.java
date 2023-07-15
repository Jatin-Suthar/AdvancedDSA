package RecursiveProblems;

import java.util.*;

public class PalindromePartitioning {

    class Solution {
        List<List<String>> ans = new ArrayList<>();
        public List<List<String>> partition(String s) {
            recur(s, s.length(), 0, new ArrayList<>());
            return ans;
        }

        public void recur(String s, int n, int idx, List<String> list) {
            if(idx==n) {
                ans.add(new ArrayList<>(list));
                return;
            }

            for(int i=idx; i<n; i++) {
                if(isPallindrome(s.substring(idx, i+1))) {
                    String sub = s.substring(idx, i+1);
                    list.add(sub);
                    recur(s, n, i+1, list);
                    list.remove(list.size()-1);
                }
            }
        }

        public boolean isPallindrome(String s) {
            int n=s.length();
            for(int i=0; i<n/2; i++) {
                if(s.charAt(i)!=s.charAt(n-1-i)) return false;
            }
            return true;
        }
    }

}
