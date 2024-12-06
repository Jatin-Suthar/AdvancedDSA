package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateBox {

    public static void main(String[] args) {
        char[][] box = {{'#','.','*','.'},
                {'#','#','*','.'}};
        RotateBoxSolution solution = new RotateBoxSolution();
        char[][] rotatedBox = solution.rotateTheBox(box);
        for(char[] row : rotatedBox) {
            System.out.println(Arrays.toString(row));
        }
    }

}

class RotateBoxSolution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length, m = box[0].length;
        char[][] ans = new char[m][n];

        for(int j=0; j<n; j++) {
            int gap = 0;
            for(int i=m-1; i>=0; i--) {
                if(box[j][i] == '.') {
                    gap++;
                } else if(box[j][i] == '#') {
                    int k = i, fill = gap;
                    while(fill>0 && k<m) {
                        ans[k][n-j-1] = '.';
                        fill--; k++;
                    }
                    ans[k][n-j-1] = '#';
                } else {
                    ans[i][n-j-1] = box[j][i];
                    int k = i+1;
                    while(gap>0 && k<m) {
                        ans[k][n-j-1] = '.';
                        gap--; k++;
                    }
                }
            }
        }
        return ans;
    }
    public char[][] rotateTheBoxOptimized(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; ++i)
            for (int j = n - 1, k = n - 1; j >= 0; --j) {
                res[j][m - i - 1] = '.';
                if (box[i][j] != '.') {
                    k = box[i][j] == '*' ? j : k;
                    res[k--][m - i - 1] = box[i][j];
                }
            }
        return res;
    }
}

/*
# 0
# 1
* 2
# 3
. 4
. 5

gap -> 2
i -> 3

#
#
*
.
.
*
 */