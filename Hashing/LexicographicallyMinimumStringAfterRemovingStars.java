package Hashing;

import java.util.*;

public class LexicographicallyMinimumStringAfterRemovingStars {
    public static void main(String[] args) {
        System.out.println(new Solution().clearStars("abba*"));
    }
    static class Solution {
        public String clearStars(String s) {
            TreeMap<Character, List<Integer>> map = new TreeMap<>();
            Set<Integer> removal = new HashSet<>();
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(c == '*') {
                    removal.add(i);
                    char smallest = map.firstKey();
                    List<Integer> idx = map.get(smallest);
                    removal.add(idx.removeLast());
                    if(idx.isEmpty()) map.remove(smallest);
                } else {
                    map.computeIfAbsent(c, key -> new ArrayList<>()).add(i);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++) {
                if(!removal.contains(i)) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}
