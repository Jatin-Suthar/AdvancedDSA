package Greedy;

public class LexicographicallySmallestString {

    public static void main(String[] args) {
        String s = "xaxcd";
        Solution_LexicographicallySmallestString sol = new Solution_LexicographicallySmallestString();
        System.out.println(sol.getSmallestString(s, 4));
    }

}

class Solution_LexicographicallySmallestString {
    public String getSmallestString(String s, int k) {
        StringBuilder ans= new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='a' || k<=0) {
                ans.append(c);
                continue;
            }
            int val = Math.min(c-'a', 'z'-c+1);
            if(val<=k) {
                ans.append('a');
                k-=val;
            } else {
                ans.append((char)(c-k));
                k=0;
            }
        }
        return ans.toString();
    }
}