class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> answer = new ArrayList<>();
        char[][] chessBoard = new char[n][n];
        int col = 0;
        
        helper(answer, col, n, chessBoard);
        return answer;
    }

    public void helper(List<List<String>> answer, int col, int n, char[][] chessBoard) {
        //base case
        if(col >= n) {
            List<String> currSeq = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder("");
                for(int j = 0 ; j < n ; j++) {
                    if(chessBoard[i][j] == 'Q') sb.append('Q');
                    else sb.append('.');
                }
                currSeq.add(sb.toString());
            }
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        for(int row = 0; row < n; row++) {
            if(isSafe(col, row, n, chessBoard)) {
                chessBoard[row][col] = 'Q';
                helper(answer, col + 1, n, chessBoard);
                chessBoard[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int col, int row, int n, char[][] chessBoard) {
        //check left side
        int R = row;
        int C = col;

        while(C >= 0) {
            if(chessBoard[R][C] == 'Q') return false;
            C--;
        }
        //check left side upper diagonal
        R = row;
        C = col;

        while(R >= 0 && C >= 0) {
            if(chessBoard[R][C] == 'Q') return false;
            R--;
            C--;
        }
        //check left side lower diagonal
        R = row;
        C = col;

        while(R < n && C >= 0) {
            if(chessBoard[R][C] == 'Q') return false;
            R++;
            C--;
        }


        return true;
    }
}