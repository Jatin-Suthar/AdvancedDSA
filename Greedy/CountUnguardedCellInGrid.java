package Greedy;

public class CountUnguardedCellInGrid {

    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int[][] guards = {{0,0},{1,1},{2,3}};
        int[][] walls = {{0,1},{2,2},{1,4}};
        CountUnguardedCellInGridSolution solution = new CountUnguardedCellInGridSolution();
        System.out.println(solution.countUnguarded(m, n, guards, walls));
    }

}

class CountUnguardedCellInGridSolution {
    int[][] box;
    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        int[][] dir = {
                {-1,0,1,0},
                {0,1,0,-1}
        };

        box = new int[n][m];
        for (int[] wall : walls) {
            box[wall[0]][wall[1]] = 2;
        }

        for (int[] guard : guards) {
            int idx = guard[0];
            int jdx = guard[1];
            box[idx][jdx] = 1;
            fillPlaces(box, idx, jdx, n, m, dir);
        }

        int emptyPlaces = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(box[i][j] == 0) emptyPlaces++;
            }
        }
        return emptyPlaces;
    }

    public void fillPlaces(int[][] box, int idx, int jdx, int n, int m, int[][] dir) {
        for (int k=0; k<4; k++) {
            int i = idx + dir[0][k], j = jdx + dir[1][k];
            while (i >= 0 && j >= 0 && i < n && j < m && box[i][j] != 2) {
                box[i][j] = 1;
                i += dir[0][k];
                j += dir[1][k];
            }
        }
    }
}

/*

G W O O O O
O G O O O O
O O O O O O
O O O O O O

*/