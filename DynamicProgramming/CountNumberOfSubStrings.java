package DynamicProgramming;

import java.util.*;

public class CountNumberOfSubStrings {

    public static void main(String[] args) {

        String s = "abaaba";
        int k = 1;
        CNOSSSolution solution = new CNOSSSolution();
        System.out.println(solution.substrCount(s, k));

    }

}

class CNOSSSolution
{
    long substrCount (String s, int k) {
        int start = 0, count = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int end=0; end<s.length(); end++) {
            char endChar = s.charAt(end);
            charMap.put(endChar, charMap.getOrDefault(endChar, 0)+1);
            if(charMap.size()>k) {
                char c = s.charAt(start);
                if(charMap.get(c)==1) {
                    charMap.remove(c);
                } else {
                    charMap.put(c, charMap.get(c)-1);
                }
                start++;
            }
            count += (end - start + 1);
        }
        return count;
    }

    private int countSubstringsWithKDistinctCharacters(String s, int k) {
        int count = 0;
        Map<Character, Integer> characterCount = new HashMap<>();
        int startIndex = 0;
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char endChar = s.charAt(endIndex);
            characterCount.put(endChar, characterCount.getOrDefault(endChar, 0) + 1);
            while (characterCount.size() > k) {
                char startChar = s.charAt(startIndex);
                if (characterCount.get(startChar) == 1) {
                    characterCount.remove(startChar);
                } else {
                    characterCount.put(startChar, characterCount.get(startChar) - 1);
                }
                startIndex++;
            }
            count += (endIndex - startIndex + 1);
        }
        return count;
    }
}