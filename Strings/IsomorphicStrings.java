package Strings;

import java.util.*;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "foo", t = "bar";
        IsomorphicStringsSolution iso = new IsomorphicStringsSolution();
        System.out.println(iso.isIsomorphic(s, t));
    }
}

class IsomorphicStringsSolution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(smap.containsKey(a) && smap.get(a)!=b) {
                return false;
            }
            if(tmap.containsKey(b) && tmap.get(b)!=a) {
                return false;
            }
            smap.put(a, b);
            tmap.put(b, a);
        }
        return true;
    }
}