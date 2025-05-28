package SlidingWindow;

import java.util.Scanner;

public class SwapForLongestRepeatedCharacterSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = "aaabaaa";
        SwapForLongestRepeatedCharacterSubstringSolution solution
                = new SwapForLongestRepeatedCharacterSubstringSolution();
        System.out.println(solution.maxRepOpt1(text));
    }
}

class SwapForLongestRepeatedCharacterSubstringSolution {
    public int maxRepOpt1(String text) {
        int n = text.length();
        int[] freq = new int[26];
        int[] count = new int[26];
        char[] s = text.toCharArray();
        for(char c: s) freq[c-'a']++;
        int st = 0, maxCount = 0, maxLength = 0;
        char maxChar = 'A';
        for(int ed = 0; ed < n; ed++) {
            if(maxCount < ++count[s[ed] - 'a']) {
                maxCount = count[s[ed] - 'a'];
                maxChar = s[ed];
            }
            if(ed-st+1-maxCount>1 || ed-st+1 > freq[maxChar-'a']) {
                count[s[st]-'a']--;
                st++;
                maxCount = 0;
                for(int i=0; i<26; i++) {
                    if(maxCount < count[i]) {
                        maxCount = count[i];
                        maxChar = (char) ('a'+i);
                    }
                }
            }
            maxLength = Math.max(maxLength, ed-st+1);
        }
        return maxLength;
    }
}
/*

aaabbaaa

aaaabaaa

bbbaabaaaa

ababcabca

aaaaaaa

abaaaacaadccccacccc

abcdefghijklmno

*/