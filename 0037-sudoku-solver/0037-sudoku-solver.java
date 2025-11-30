class Solution {
    public void solveSudoku(char[][] board) {

        int count = 0;
        int col = 0;
        helper(board);
        return;
    }

    public boolean helper(char[][] board) {
        // if(col == board.length) {
        //     return true;
        // }
        //recursive case
        for(int col = 0; col < board.length; col++) {
            for(int row = 0; row < board.length; row++) {
                if(board[row][col] == '.') {
                    for(char validNum = '1'; validNum <= '9'; validNum++) {
                        if(isValid(board, col, row, validNum)) {
                            board[row][col] = validNum;
                            if (helper(board)) return true;
                            else board[row][col] = '.';
                        }
                    }
                    return false;
                }
             }
        }
        
        return true;
    }

    public boolean isValid(char[][] board, int col, int row, char validNum) {

        
        for( int i = 0;  i < 9; i++) {
            //check for entire row
            if(board[row][i] == validNum) return false;

            //check for entire col
            if(board[i][col] == validNum) return false;

            //check 3 * 3 matrix
            if(board[(3 * (row/3)) + (i/3)][ (3 * (col/3)) + (i % 3)] == validNum) return false;
        }
        
        return true;
    }
}