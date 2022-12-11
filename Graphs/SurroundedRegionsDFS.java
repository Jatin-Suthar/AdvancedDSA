package Graphs;

public class SurroundedRegionsDFS {
    public void solve(char[][] board) {
        //first we try to check whether there are corner O's or not
        int jidx = 0;
        int iidx = 0;
        for(int i = 0 ; i < board[0].length ; i++){
            if(board[0][i] == 'O'){
                iidx = 0;
                jidx = i;
                traverse(board, iidx, jidx);
            }
        }
        jidx = 0;
        iidx = 0;
        for(int i = 0 ; i < board.length ; i++){
            if(board[i][0] == 'O'){
                iidx = i;
                jidx = 0;
                traverse(board, iidx, jidx);
            }
        }
        jidx = board[0].length-1;
        iidx = 0;
        for(int i = 0 ; i < board.length ; i++){
            if(board[i][jidx] == 'O'){
                iidx = i;
                traverse(board, iidx, jidx);
            }
        }
        jidx = 0;
        iidx = board.length-1;
        for(int i = 0 ; i < board[0].length ; i++){
            if(board[iidx][i] == 'O'){
                jidx = i;
                traverse(board, iidx, jidx);
            }
        }
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public static void traverse(char[][] board, int i, int j){
        board[i][j] = 'S';
        if(j < board[0].length-1 && board[i][j+1] == 'O'){
            traverse(board, i, j+1);
        }
        if(j > 0 && board[i][j-1] == 'O'){
            traverse(board, i, j-1);
        }
        if(i < board.length-1 && board[i+1][j] == 'O'){
            traverse(board, i+1, j);
        }
        if(i > 0 && board[i-1][j] == 'O'){
            traverse(board, i-1, j);
        }    
    }
}
