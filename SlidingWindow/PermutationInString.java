package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static void main(String[] args) {
        String s11 = "ab", s12 = "eidbaooo";
        String s21 = "abc", s22 = "cbca";
        String s31 = "rmqqh", s32 = "nrsqrqhrymf";
        System.out.println("First case: " + checkInclusion(s11, s12));
        System.out.println("Second case: " + checkInclusion(s21, s22));
        System.out.println("Third case: " + checkInclusion(s31, s32));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int l=0, r=0, count=0;

        Map<Character, Integer> fMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(char c: s1.toCharArray()) fMap.put(c, fMap.getOrDefault(c, 0)+1);

        while(r!=s2.length()) {
            char curr = s2.charAt(r);
            if(fMap.get(curr)!=null) {
                sMap.put(curr, sMap.getOrDefault(curr, 0)+1);
                count++;
                if(count == s1.length()) {
                    if(fMap.equals(sMap)) {
                        return true;
                    } else {
                        count--;
                        int freq = sMap.get(s2.charAt(l))-1;
                        sMap.put(s2.charAt(l), freq);
                        l++;
                    }
                }
            } else {
                l = r+1; count = 0;
                sMap.clear();
            }
            r++;
        }

        return false;
    }

}
