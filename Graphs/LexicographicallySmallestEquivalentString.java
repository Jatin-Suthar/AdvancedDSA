package Graphs;

import java.util.*;

public class LexicographicallySmallestEquivalentString {
    public static void main(String[] args) {
        String s1 = "parker", s2 = "morris", baseStr = "parser";
        System.out.println(new Solution().smallestEquivalentString(s1, s2, baseStr));
    }
    static class Solution {
        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            List<List<Integer>> adjList = new ArrayList<>();
            int m = s1.length(), n = baseStr.length();
            for(int i=0; i<26; i++) adjList.add(new ArrayList<>());
            for(int i=0; i<m; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if(c1==c2) continue;
                adjList.get(c1-'a').add(c2-'a');
                adjList.get(c2-'a').add(c1-'a');
            }
            StringBuilder sb = new StringBuilder();
            int[] smallest = new int[26];
            boolean[] visited = new boolean[26];
            for(char c: baseStr.toCharArray()) {
                int idx = c-'a';
                if(!visited[idx]) {
                    recur(idx, adjList, smallest, visited, idx);
                }
                sb.append((char)('a' + smallest[idx]));
            }
            return sb.toString();
        }
        public int recur(int u, List<List<Integer>> adjList, int[] smallest, boolean[] visited, int min) {
            visited[u] = true;
            min = Math.min(min, u);
            for(int v: adjList.get(u)) {
                if(!visited[v]) {
                    min = Math.min(min, recur(v, adjList, smallest, visited, min));
                }
            }
            return smallest[u] = min;
        }
    }

/*

parker
morris

p - m
a - o
r - r,k,s
e - i

parser

makkek

*/
}
