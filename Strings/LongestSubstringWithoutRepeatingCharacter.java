package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {

        String s = " ";
        LongestSubstringWithoutRepeatingCharacterSolution solution = new LongestSubstringWithoutRepeatingCharacterSolution();
        System.out.println(solution.lengthOfLongestSubstringOn1(s));

    }

}

class LongestSubstringWithoutRepeatingCharacterSolution {

    public int lengthOfLongestSubstringOn1(String s) {
        int max = 0, left = 0;
        int[] indexes = new int[128];
        Arrays.fill(indexes, -1);
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(indexes[c]>=left) {
                left = indexes[c]+1;
            }
            indexes[c]=i;
            max = Math.max(max, (i-left+1));
        }
        return max;
    }

    public int lengthOfLongestSubstringOn2(String s) {
        int max = 0, n = s.length();
        for(int i=0; i<n; i++) {
            Set<Character> freq = new HashSet<>();
            int j = i;
            for( ; j<n; j++) {
                char c = s.charAt(j);
                if(freq.contains(c)) {
                    max = Math.max(max, (j-i));
                    break;
                }
                freq.add(c);
            }
            if(j==n) {
                max = Math.max(max, (j-i));
            }
        }
        return max;
    }

}