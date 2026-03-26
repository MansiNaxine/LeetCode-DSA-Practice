class Solution {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        int[][] valid = new int[rows][cols];
        StringBuilder sb = new StringBuilder("");
        char ch = word.charAt(0);

        //Check first letter
        for(int i = 0 ; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == ch) {
                    valid[i][j] = 1;
                    sb.append(board[i][j]);
                    if( helper(valid, i, j, word, board, 1, sb, rows, cols)) return true;
                    else {
                        sb.deleteCharAt(sb.length()-1);
                        valid[i][j] = 0;
                    }
                }
            }
        }

        return false;
        
    }

    public boolean helper(int[][] valid, int i, int j, String word, char[][] board, int index, StringBuilder sb, int rows, int cols) {
       //Base case
        if(index >= word.length()) {
            if(sb.toString().equals(word)) return true;
            return false;
        }

        //Recursive case

        //UP direction
        if((i-1) >= 0 && board[i-1][j] == word.charAt(index) && valid[i-1][j] == 0) {
            valid[i-1][j] = 1;
            sb.append(board[i-1][j]);
            if(helper(valid, i-1, j, word, board, index + 1, sb, rows, cols)) return true;
            valid[i-1][j] = 0;
            sb.deleteCharAt(sb.length()-1);
        }
        
        //DOWN direction
        if((i+1) <= rows-1 && board[i+1][j] == word.charAt(index) && valid[i+1][j] == 0) {
            valid[i+1][j] = 1;
            sb.append(board[i+1][j]);
            if(helper(valid, i+1, j, word, board, index + 1, sb, rows, cols)) return true;
            valid[i+1][j] = 0;
            sb.deleteCharAt(sb.length()-1);
        }
        //LEFT direction
        if((j-1) >= 0 && board[i][j-1] == word.charAt(index) && valid[i][j-1] == 0) {
            valid[i][j-1] = 1;
            sb.append(board[i][j-1]);
            if(helper(valid, i, j-1, word, board, index + 1, sb, rows, cols)) return true;
            valid[i][j-1] = 0;
            sb.deleteCharAt(sb.length()-1);
        }
        //RIGHT direction
        if((j+1) <= cols-1 && board[i][j+1] == word.charAt(index) && valid[i][j+1] == 0) {
            valid[i][j+1] = 1;
            sb.append(board[i][j+1]);
            if(helper(valid, i, j+1, word, board, index + 1, sb, rows, cols)) return true;
            valid[i][j+1] = 0;
            sb.deleteCharAt(sb.length()-1);
        }
        

        return false;
    }
}