package Hashing;

import java.util.*;

public class MinimumDeletionToMakeKSpecial {
    static class Solution {
        public int minimumDeletions(String word, int k) {
            int n = word.length();
            char[] arr = word.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            List<Pair> alp = new ArrayList<>();
            for(char c: map.keySet()) {
                alp.add(new Pair(c, map.get(c)));
            }
            alp.sort(Comparator.comparing(a -> a.freq));
            int min = n;
            for(int i=0; i<alp.size(); i++) {
                int x = alp.get(i).freq;
                int max = x + k;
                int count = 0;
                for(int j=0; j<alp.size(); j++) {
                    if(i!=j) {
                        int y = alp.get(j).freq;
                        if(y > max) {
                            count += (y-x-k);
                        } else if (y < x) {
                            count += (x);
                        }
                    }
                }
                min = Math.min(min, count);
            }
            return min;
        }
        static class Pair {
            char c;
            int freq;
            public Pair(char c, int freq) {
                this.c = c;
                this.freq = freq;
            }
        }
    }
/*

aaaabbc
anncccdddddd

a - b = k

*/
}
