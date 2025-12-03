class Solution {
    public int totalNQueens(int n) {
        
        List<List<String>> answer = new ArrayList<>();
        char[][] chessBoard = new char[n][n];
        helper(chessBoard, answer, n, 0);
        return answer.size();
    }

    public void helper(char[][] chessBoard, List<List<String>> answer, int n, int col) {
        //base case
        if(col == n) {
            List<String> completeOneChessBoard = new ArrayList<>();
            printAllChessBoard(completeOneChessBoard, n, chessBoard);
            answer.add(new ArrayList<>(completeOneChessBoard));
            return;
        }

        //recursive case
        for(int row = 0; row < n; row++) {
            if(isSafe(chessBoard, row, col, n)){
                chessBoard[row][col] = 'Q';
                helper(chessBoard, answer, n , col + 1);
                chessBoard[row][col] = '.';
            }
        }
    }

    public void printAllChessBoard(List<String> completeOneChessBoard, int n, char[][] chessBoard) {
        
        for(char[] chRow : chessBoard) {
            StringBuilder sb = new StringBuilder();
            for(char ch : chRow) {
                if(ch != 'Q') sb.append('.');
                else sb.append(ch);
            }

            completeOneChessBoard.add(sb.toString());
        }
    }

    public boolean isSafe(char[][] chessBoard, int row, int col, int n) {
        int r = row;
        int c = col;

        //Check left side
        while(c >= 0) {
            if(chessBoard[r][c] == 'Q') return false;
            else c--;
        }

        //Check left upper diagonal
        c = col;
        while(r >= 0 && c >= 0) {
            if(chessBoard[r][c] == 'Q') return false;
            else {
                r--;
                c--;
            }
        }

        //Check left lower diagonal
        r = row;
        c = col;
        while(r < n && c >= 0) {
            if(chessBoard[r][c] == 'Q') return false;
            else {
                r++;
                c--;
            }
        }
        return true;
    }
}