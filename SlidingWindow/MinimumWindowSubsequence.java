package SlidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumWindowSubsequence {

    public static void main(String[] args) {
        String str1 = "geeksforgeeksrge";
        String str2 = "eksrge";
        System.out.println(minWindow(str1, str2));
    }

    static String minWindow(String s, String t) {
        int tIdx = 0, n = s.length(), minWindow = s.length();
        String res = "";
        for(int sIdx = 0; sIdx < n; sIdx++) {
            if(s.charAt(sIdx) == t.charAt(tIdx)) {
                tIdx++;
                if(tIdx >= t.length()) {
                    int end = sIdx+1;
                    tIdx--;
                    while(tIdx >= 0) {
                        if(s.charAt(sIdx) == t.charAt(tIdx)) {
                            tIdx--;
                        }
                        sIdx--;
                    }
                    sIdx++;
                    tIdx++;
                    if(end-sIdx < minWindow) {
                        minWindow = end-sIdx;
                        res = s.substring(sIdx, end);
                    }
                }
            }
        }
        return res;
    }

}
