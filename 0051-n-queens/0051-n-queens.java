class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] chessBoard = new char[n][n];
        helper(answer, chessBoard, n, 0);
        return answer;
    }

     public void helper(List<List<String>> answer, char[][] chessBoard, int n, int col) {
        //base case
        if(col == n) {
           //print the chessboard
            List<String> currSeq = new ArrayList<>();
            printChessBoard(currSeq, chessBoard);
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        //iterate through each row for given column
        for(int row = 0; row < n; row++) {
            if(isSafe(chessBoard, row, col, n)) {
                chessBoard[row][col] = 'Q';
                helper(answer, chessBoard, n, col + 1);
                chessBoard[row][col] = '.';
            }
        }
    }

    public void printChessBoard(List<String> completeOneChessBoard, char[][] chessBoard) {
        for(char[] firstRow : chessBoard) {
            StringBuilder sb = new StringBuilder();
            for(char ch : firstRow) {
                if(ch != 'Q') sb.append('.');
                else sb.append(ch);
            }
            completeOneChessBoard.add(sb.toString());
        }
    }

    public boolean isSafe(char[][] chessBoard,int row, int col, int n) {
        //we have to check for the three left side
        int i = row;
        int j = col;

        //straight left
        while(j >= 0) {
            if(chessBoard[i][j] == 'Q') return false;
            else j--;
        }
        //left upper diagonal
        i = row;
        j = col;
        while(i >= 0 && j >= 0) {
            if(chessBoard[i][j] == 'Q') return false;
            else {
                i--;
                j--;
            }
        }
        //left lower diagonal
        i = row;
        j = col;
        while(i < n && j >= 0) {
            if(chessBoard[i][j] == 'Q') return false;
            else {
                i++;
                j--;
            }
        }
       return true;
    }


}