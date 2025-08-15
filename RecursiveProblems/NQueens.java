package RecursiveProblems;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }
    static class Solution {
        List<List<String>> ans = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            recur(new ArrayList<>(), "", n, 0, 0);
            return ans;
        }
        public boolean recur(List<String> board, String curr, int n, int i, int j) {
            if(i>=n && j>=n) {
                ans.add(new ArrayList<>(board));
                return true;
            }
            if(i<n && j<n && isFeasibleToPlace(board, curr, n, i, j)) {
                recur(board, curr+'Q', n, i, j+1);
            }
            if(j>=n) {
                board.add(curr);
                boolean isFeasible = curr.contains("Q") && recur(board, "", n, i+1, 0);
                board.removeLast();
                return isFeasible;
            } else {
                return recur(board, curr + '.', n, i, j + 1);
            }
        }
        public boolean isFeasibleToPlace(List<String> board, String curr, int n, int i, int j) {
            for(int k=0; k<curr.length(); k++) {
                if(curr.charAt(k) == 'Q') return false;
            }
            for(String prevRow: board) {
                if(prevRow.charAt(j) == 'Q') return false;
            }
            int a = i-1, b = j-1;
            while(a >= 0 && b >= 0) {
                if(board.get(a).charAt(b) == 'Q') return false;
                a--; b--;
            }
            a = i-1; b = j+1;
            while(a >= 0 && b < n) {
                if(board.get(a).charAt(b) == 'Q') return false;
                a--; b++;
            }
            return true;
        }
    }
}
