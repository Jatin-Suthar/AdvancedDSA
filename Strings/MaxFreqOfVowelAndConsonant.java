package Strings;

public class MaxFreqOfVowelAndConsonant {
}

class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c-'a']++;
        }
        int maxVowel = 0;
        int maxCnsnt = 0;
        for(int i=0; i<26; i++) {
            char curr = (char) ('a'+i);
            switch(curr) {
                case 'a', 'e', 'i', 'o', 'u':
                    maxVowel = Math.max(freq[i], maxVowel);
                    break;
                default:
                    maxCnsnt = Math.max(freq[i], maxCnsnt);
            }
        }
        return maxVowel + maxCnsnt;
    }
}