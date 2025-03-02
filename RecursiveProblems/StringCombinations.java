package RecursiveProblems;

import java.util.ArrayList;
import java.util.List;

public class StringCombinations {
    public static void main(String[] args) {
        StringCombinationsSolution solution
                = new StringCombinationsSolution();
        System.out.println(solution.getSubsequence("abc"));
    }
}

class StringCombinationsSolution {
    public List<String> getSubsequence(String s) {
        recur(s, "", new boolean[s.length()]);
        return subsequence;
    }
    List<String> subsequence = new ArrayList<>();
    public void recur(String s, String t, boolean[] visited) {
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!visited[i]) {
                t+=c;
                visited[i] = true;
                recur(s, t, visited);
                visited[i] = false;
                t = t.substring(0, t.length()-1);
            }
        }
        subsequence.add(t);
    }
}
/*

[1,0,1]
ac
abc, ab, acb, ac

*/
