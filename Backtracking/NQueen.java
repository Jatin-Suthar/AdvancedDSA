package Backtracking;

import java.util.*;

public class NQueen {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            boolean ithVis[] = new boolean[n];

            List<List<String>> res = new ArrayList<>();
            List<String> list = new ArrayList<>();
            recur(n, 0, list, res, ithVis);
            return res;
        }

        public void recur(int n, int idx, List<String> list, List<List<String>> res, boolean[] ith) {
            if(idx==n) {
                res.add(new ArrayList<>(list));
                return;
            }

            for(int i=0; i<n; i++) {
                if(isValidPosition(i, n, list, ith)) {
                    String s = "";
                    int j=0;
                    while(j<i) {
                        s+='.';
                        j++;
                    }
                    ith[i]=true;
                    s += 'Q';
                    j=i+1;
                    while(j<n) {
                        s+='.';
                        j++;
                    }
                    list.add(s);
                    recur(n, idx+1, list, res, ith);
                    ith[i]=false;
                    list.remove(list.size()-1);
                }
            }
        }

        public boolean isValidPosition(int i, int n, List<String> list, boolean[] ith) {
            if(list.isEmpty()) return true;
            if(ith[i]) return false;
            String prevStr = list.get(list.size()-1);

            if(i<n-1) {
                if(i>0) {
                    return prevStr.charAt(i-1)!='Q' && prevStr.charAt(i+1)!='Q';
                } else {
                    return prevStr.charAt(i+1)!='Q';
                }
            } else {
                return prevStr.charAt(i-1)!='Q';
            }
        }
    }
}

