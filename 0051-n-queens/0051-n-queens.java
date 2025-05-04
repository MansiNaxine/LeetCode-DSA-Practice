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

        solveNQueensHelper(n, chessBoard, 0);
        return answer;
    }

    public void solveNQueensHelper(int n, List<StringBuilder> chessBoard, int row) {

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
            if(isSafe(chessBoard, n,row, j)) {
                chessBoard.get(row).setCharAt(j, 'Q');
                solveNQueensHelper(n, chessBoard, row + 1);
                chessBoard.get(row).setCharAt(j, '.');
            }
        }
    }


    public boolean isSafe(List<StringBuilder> chessBoard, int n, int row, int col) {

        //check top left
        int r = row;
        int c = col;

        while(r >= 0 && c >= 0) {
            if(chessBoard.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }

        //check for top

        r = row;

        while(r >= 0) {
            if(chessBoard.get(r).charAt(col) == 'Q') return false;
            r--;
        }

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