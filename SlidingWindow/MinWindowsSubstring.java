package SlidingWindow;

public class MinWindowsSubstring {
}

class MinWindowsSubstringSolution {
    public String minWindow(String s, String t) {
        int start = 0, minLen = Integer.MAX_VALUE, matched = 0;
        String result = "";
        int n = s.length();

        // Initialize the frequency array for the characters in t
        int[] charFrequency = new int[58]; // 58 to cover 'A'-'Z' and 'a'-'z' (from 'A' to 'z')
        for (char c : t.toCharArray()) {
            charFrequency[c - 'A']++;
        }

        // Use two pointers to traverse the string s
        for (int end = 0; end < n; end++) {
            char currChar = s.charAt(end);
            charFrequency[currChar - 'A']--;
            if (charFrequency[currChar - 'A'] >= 0) {
                matched++;
            }

            // When we have matched all characters in t
            while (matched == t.length()) {
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    result = s.substring(start, end + 1);
                }
                char startChar = s.charAt(start++);
                charFrequency[startChar - 'A']++;
                if (charFrequency[startChar - 'A'] > 0) {
                    matched--;
                }
            }
        }
        return result;
    }
}
