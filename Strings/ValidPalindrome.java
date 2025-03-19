package Strings;

public class ValidPalindrome {
}
class ValidPalindromeSolution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                sb.append(Character.toLowerCase(c));
            } else if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        String palindrome = sb.toString();
        int st = 0, ed = palindrome.length()-1;
        while(st<ed) {
            if(palindrome.charAt(st)!=palindrome.charAt(ed)) return false;
            st++; ed--;
        }
        return true;
    }
}