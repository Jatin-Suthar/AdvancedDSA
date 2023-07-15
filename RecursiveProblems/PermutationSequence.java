package RecursiveProblems;

import java.util.*;

public class PermutationSequence {

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public String getPermutation(int n, int k) {
            recur(n+1, new boolean[n], new ArrayList<>(), k);
            List<Integer> list = ans.get(k-1);
            String res = "";
            for(int i: list) {
                res += i;
            }
            return res;
        }

        public void recur(int n, boolean[] visited, List<Integer> carry, int k) {
            if(carry.size()==n-1) {
                ans.add(new ArrayList<>(carry));
                return;
            }

            if(ans.size()<k) {
                for(int i=1; i<n; i++) {
                    if(!visited[i-1]) {
                        carry.add(i);
                        visited[i-1]=true;
                        recur(n, visited, carry, k);
                        visited[i-1]=false;
                        carry.remove(carry.size()-1);
                    }
                }
            }
        }
    }

}
