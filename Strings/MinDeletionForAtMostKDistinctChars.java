package Strings;

import java.util.*;

public class MinDeletionForAtMostKDistinctChars {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abc";
        int k = 2;
        System.out.println(solution.minDeletion(s, k));
    }
    static class Solution {
        public int minDeletion(String s, int k) {
            int[] freq = new int[26];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(char c: s.toCharArray()) {
                freq[c-'a']++;
            }
            for(int i=0; i<26; i++) {
                if(freq[i]!=0) pq.add(freq[i]);
            }
            int ans = 0;
            while(!pq.isEmpty() && pq.size()>k) {
                ans += pq.poll();
            }
            return ans;
        }
    }
}
