class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
        return;
    }

    public boolean helper(char[][] board) {
        //Traverse from 1 to 9
        int n = board.length;
    
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') {
                    for(char index = '1'; index <= '9'; index++) {
                        if(isValid(board, i, j, index)) {
                            board[i][j] = (char)index;
                            if(helper(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
                
            }
        }

        return true;

    }


    public boolean isValid(char[][] board, int row, int col, char ch) {

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