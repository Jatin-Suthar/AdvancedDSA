package Hashing;

import java.util.*;

public class CountCellsInOverlappingHorizontalAndVerticalSubArray {
    public static void main(String[] args) {
        char[][] grid = {{'a','a','b'},{'a','b','a'},{'b','a','b'}};
        String pattern = "aba";
        CountCellsInOverlappingHorizontalAndVerticalSubArraySolution solution
                = new CountCellsInOverlappingHorizontalAndVerticalSubArraySolution();
        System.out.println(solution.countCells(grid, pattern));
    }
}

class CountCellsInOverlappingHorizontalAndVerticalSubArraySolution {
    public int countCells(char[][] grid, String pattern) {
        int n = grid.length, m = grid[0].length, plen = pattern.length();
        int total = n * m;

        // Flatten grid horizontally with wrap
        char[] horiz = new char[total];
        for (int i = 0, idx = 0; i < n; i++) {
            for (int j = 0; j < m; j++, idx++) {
                horiz[idx] = grid[i][j];
            }
        }

        // Flatten grid vertically with wrap
        char[] vert = new char[total];
        for (int j = 0, idx = 0; j < m; j++) {
            for (int i = 0; i < n; i++, idx++) {
                vert[idx] = grid[i][j];
            }
        }

        boolean[] horizMatch = new boolean[total];
        boolean[] vertMatch = new boolean[total];

        // Search pattern in horiz and vert arrays
        kmp(horiz, pattern, horizMatch);
        kmp(vert, pattern, vertMatch);

        // Mark cells
        boolean[][] horizontal = new boolean[n][m];
        boolean[][] vertical = new boolean[n][m];

        for (int i = 0; i < total; i++) {
            if (horizMatch[i]) {
                for (int k = 0; k < plen; k++) {
                    int pos = (i + k) % total;
                    int row = pos / m, col = pos % m;
                    horizontal[row][col] = true;
                }
            }
            if (vertMatch[i]) {
                for (int k = 0; k < plen; k++) {
                    int pos = (i + k) % total;
                    int row = pos % n, col = pos / n;
                    vertical[row][col] = true;
                }
            }
        }

        // Count overlap
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (horizontal[i][j] && vertical[i][j]) ans++;

        return ans;
    }

    private void kmp(char[] text, String pattern, boolean[] match) {
        int n = text.length, m = pattern.length();
        int[] lps = buildLPS(pattern);

        int i = 0, j = 0;
        while (i < n) {
            if (text[i] == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    match[i - m] = true;
                    j = lps[j-1];
                }
            } else {
                if (j > 0) j = lps[j-1];
                else i++;
            }
        }
    }

    public int[] buildLPS(String pat) {
        int n = pat.length();
        int[] lps = new int[n];
        int len = 0, i = 1;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                if (len != 0) len = lps[len-1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }
}
/*

aba
 l i

lps: 001

aabababab



*/