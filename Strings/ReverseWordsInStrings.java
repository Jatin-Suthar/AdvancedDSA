package Strings;

public class ReverseWordsInStrings {
    public static void main(String[] args) {
        String s = " Hello    World ";
        RWISSolution solution = new RWISSolution();
        System.out.println(solution.reverseWords(s));
    }
}

class RWISSolution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int end = 0;
        while(end<s.length()) {
            while(end<s.length() && s.charAt(end)==' ') {end++;}
            StringBuilder temp = new StringBuilder();
            while(end<s.length() && s.charAt(end)!=' ') {
                temp.append(s.charAt(end));
                end++;
            }
            res.insert(0, temp + " ");
            while(end<s.length() && s.charAt(end)==' ') {end++;}
        }
        return res.toString().trim();
    }
}