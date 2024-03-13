package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfString {

    public static List<String> subsequence(String s, String temp) {
        List<String> list = new ArrayList<>();
        if(s.isEmpty()) {
            list.add(temp);
            return list;
        }
        char c = s.charAt(0);
        list.addAll(subsequence(s.substring(1), temp+c));
        list.addAll(subsequence(s.substring(1), temp));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(subsequence("Ujjwal", ""));
    }

}