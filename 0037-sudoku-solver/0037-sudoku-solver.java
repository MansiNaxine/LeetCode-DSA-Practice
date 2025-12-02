class Solution {
    public void solveSudoku(char[][] board) {

        helper(board);
        return ;
        
    }

    public boolean helper(char[][] board) {

        for(int col = 0; col < board.length; col++) {
            for(int row = 0; row < board.length; row++) {
                if(board[row][col] == '.') {
                    for(char ch = '1'; ch <= '9'; ch++) {
                        if(isValid(board, row, col, ch)) { // Check if given char can be place at current position
                            board[row][col] = ch;

                            if(helper(board)) return true;
                            else board[row][col] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValid(char[][] board, int row, int col, int ch) {

        for(int i = 0; i < board.length; i++) {

            //Check for Entire row
            if(board[row][i] == ch) return false;

            //Check for Entire column
            if(board[i][col] == ch) return false;

            //Check for 3 * 3 matrix
            if(board[(3 * (row/3)) + i/3][(3 * ( col/3)) + i%3] == ch) return false;
        }

        return true;
    }
}