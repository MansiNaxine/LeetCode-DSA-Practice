class Solution {

    List<List<String>> answer = new ArrayList<>();
    List<StringBuilder> chessBoard = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        
        //for the empty chessboard
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder("");
            for(int j = 0; j < n; j++) {
                sb.append(".");
            }
            chessBoard.add(sb);
        }

        //For optimization
        int[] colArr = new int[n];
        int[] left_diagonal = new int[2*n - 1];
        int[] right_diagonal = new int[2*n - 1];
        solveNQueensHelper(n, chessBoard, 0, colArr, left_diagonal, right_diagonal);
        return answer;
    }

    public void solveNQueensHelper(int n, List<StringBuilder> chessBoard, int row, int[] colArr, int[] left_diagonal, int[] right_diagonal) {

        //base case
        if(row == n) {
            List<String> currSeq = new ArrayList<>();
            for(int i = 0; i < chessBoard.size(); i++) {
                currSeq.add(chessBoard.get(i).toString());
            }

            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        for(int j = 0; j < n; j++) {
            if(isSafe(chessBoard, n,row, j, colArr, left_diagonal, right_diagonal)) {
                chessBoard.get(row).setCharAt(j, 'Q');
                colArr[j] = 1;
                left_diagonal[row-j+n-1] = 1;
                right_diagonal[row+j] = 1;
                solveNQueensHelper(n, chessBoard, row + 1, colArr, left_diagonal, right_diagonal);
                colArr[j] = 0;
                left_diagonal[row-j+n-1] = 0;
                right_diagonal[row+j] = 0;
                chessBoard.get(row).setCharAt(j, '.');
            }
        }
    }


    public boolean isSafe(List<StringBuilder> chessBoard, int n, int row, int col, int[] colArr,int[] left_diagonal, int[] right_diagonal) {

        //check top left
        // int r = row;
        // int c = col;

        // while(r >= 0 && c >= 0) {
        //     if(chessBoard.get(r).charAt(c) == 'Q') return false;
        //     r--;
        //     c--;
        // }

        //for optimization purpose of left diagonal
        if(left_diagonal[row-col+n-1] == 1) return false;

        //check for top

        // r = row;

        // while(r >= 0) {
        //     if(chessBoard.get(r).charAt(col) == 'Q') return false;
        //     r--;
        // }

        //for optimization purpose
        if(colArr[col] == 1) return false;

        //top right
        // r = row;
        // c = col;

        // while(r >= 0 && c < n) {
        //     if(chessBoard.get(r).charAt(c) == 'Q') return false;
        //     r--;
        //     c++;
        // }

        //for optimization purpose of right diagonal
        if(right_diagonal[row+col] == 1) return false;

        return true;
    }
}