package SlidingWindow;

public class LongestRepeatingCharReplacements {

    public static void main(String[] args) {
        int a[] = new int[1];
        int b[] = new int[1];
        if(a.equals(b)) {
            System.out.println("a equals to b");
        }

        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int l = 0, max = 0, maxFreq = 0;
        for(int r = 0; r < s.length(); r++) {
            int idx = s.charAt(r)-'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
            while((r-l+1)-maxFreq > k) {
                freq[s.charAt(l)-'A']--;
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }

}
