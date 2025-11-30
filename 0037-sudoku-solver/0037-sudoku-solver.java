class Solution {
    public void solveSudoku(char[][] board) {

        int count = 0;
        int col = 0;
        helper(board, 0);
        return;
    }

    public boolean helper(char[][] board, int pos) {
        if (pos == board.length * board.length) return true; // finished all cells

        int row = pos / board.length;
        int col = pos % board.length;

        if (board[row][col] != '.') {
            return helper(board, pos + 1); // skip filled cells
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, col, row, num)) {
                board[row][col] = num;
                if (helper(board, pos + 1)) return true;
                board[row][col] = '.';
            }
        }
    return false;
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