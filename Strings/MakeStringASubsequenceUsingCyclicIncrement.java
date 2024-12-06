package Strings;

public class MakeStringASubsequenceUsingCyclicIncrement {
    public boolean canMakeSubsequence(String str1, String str2) {
        int idx = 0;
        for (char c : str1.toCharArray()) {
            if (idx >= str2.length()) break;
            char target = str2.charAt(idx);
            if (c == target || (target == 'a' ? c == 'z' : c == target - 1)) {
                idx++;
            }
        }
        return idx == str2.length();
    }
}
