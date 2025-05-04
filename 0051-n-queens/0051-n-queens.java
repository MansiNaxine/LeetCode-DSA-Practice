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
        solveNQueensHelper(n, chessBoard, 0, colArr);
        return answer;
    }

    public void solveNQueensHelper(int n, List<StringBuilder> chessBoard, int row, int[] colArr) {

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
            if(isSafe(chessBoard, n,row, j, colArr)) {
                chessBoard.get(row).setCharAt(j, 'Q');
                colArr[j] = 1;
                solveNQueensHelper(n, chessBoard, row + 1, colArr);
                colArr[j] = 0;
                chessBoard.get(row).setCharAt(j, '.');
            }
        }
    }


    public boolean isSafe(List<StringBuilder> chessBoard, int n, int row, int col, int[] colArr) {

        //check top left
        int r = row;
        int c = col;

        while(r >= 0 && c >= 0) {
            if(chessBoard.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }

        //check for top

        // r = row;

        // while(r >= 0) {
        //     if(chessBoard.get(r).charAt(col) == 'Q') return false;
        //     r--;
        // }

        //for optimization purpose
        if(colArr[col] == 1) return false;

        //top right
        r = row;
        c = col;

        while(r >= 0 && c < n) {
            if(chessBoard.get(r).charAt(c) == 'Q') return false;
            r--;
            c++;
        }

        return true;
    }
}