package Strings;

import java.util.*;

public class WordSubsets {

    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"}, words2 = {"lc","eo"};
        WordSubsetsSolution solution = new WordSubsetsSolution();
        System.out.println(solution.wordSubsets(words1, words2));
    }

}
class WordSubsetsSolution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        Map<Character, int[]> map = new HashMap<>();
        int i=0;
        for(String s: words2) {
            for(char c: s.toCharArray()) {
                map.computeIfAbsent(c, k -> new int[words2.length]);
                map.get(c)[i]++;
            }
            i++;
        }
        List<String> result = new ArrayList<>();
        for(String str: words1) {
            int[] freqA = new int[26];
            for(char c: str.toCharArray()) {
                freqA[c-'a']++;
            }
            boolean isValid = true;
            for(Character c: map.keySet()) {
                int[] freqB = map.get(c);
                for(int freq: freqB) {
                    if (freq > freqA[c - 'a']) {
                        isValid = false;
                        break;
                    }
                }
            }
            if(isValid) {
                result.add(str);
            }
        }
        return result;
    }
}

/*
['c', 'cc', 'b']
c->0

*/