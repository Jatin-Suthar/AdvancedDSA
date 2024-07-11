package Arrays;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        placeQueens(res, new ArrayList<>(), "", 0, 0, n, new boolean[n]);
        return res;
    }
    public static void placeQueens(List<List<String>> res, List<String> list, String temp, int i, int j, int n, boolean[] invalid) {
        if(i==n) { return; }
        if(j==n) {
            if(!invalid[i]) return;
            list.add(temp);
            if(i==n-1) {
                res.add(new ArrayList<>(list));
            } else {
                placeQueens(res, list, "", i+1, 0, n, invalid);
            }
            return;
        }
        if(!invalid[i] && !isQueenSafe(list, n, i, j)) {
            invalid[i] = true;
            temp += 'Q';
            placeQueens(res, list, temp, i, j+1, n, invalid);
            invalid[i] = false;
            if(list.size()>=i+1) {
                list.remove(list.size()-1);
            }
            temp = temp.substring(0, temp.length() - 1);
        }
        temp += '.';
        placeQueens(res, list, temp, i, j+1, n, invalid);
    }
    public static boolean isQueenSafe(List<String> list, int n, int i, int j) {
        if(list.isEmpty()) return false;
        int ii = i-1;
        while(ii>=0) {
            if(list.get(ii).charAt(j)=='Q') {
                return true;
            }
            ii--;
        }
        int jj = j-1; ii = i-1;
        while(ii>=0 && jj>=0) {
            if(list.get(ii).charAt(jj)=='Q') {
                return true;
            }
            ii--;
            jj--;
        }
        ii = i-1; jj = j+1;
        while(ii>=0 && jj<n) {
            if(list.get(ii).charAt(jj)=='Q') {
                return true;
            }
            ii--;
            jj++;
        }
        return false;
    }

}
