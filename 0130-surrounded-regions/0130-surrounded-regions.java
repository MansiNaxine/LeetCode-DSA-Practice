class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        defsTraversal(board, n, m);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
                else board[i][j] = 'X';
            }
        }

        return;
    }

    public void defsTraversal(char[][] board, int n, int m) {
        //Check all boundaries
        //Check down
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            int col = 0;
            if(board[i][col] == 'O') {
                dfsRecursion(board, visited, delRow, delCol, n, m, i, col);
            }
        }

        //check right
        for(int i = 0; i < m; i++) {
            int row = 0;
            if(board[row][i] == 'O') {
                dfsRecursion(board, visited, delRow, delCol, n, m, row, i);
            }
        }

        //check right column
        for(int i = 0; i < n; i++) {
            int col = m - 1;
            if(board[i][col] == 'O') {
                dfsRecursion(board, visited, delRow, delCol, n, m, i, col);
            }
        }

        //check bottom right
        for(int i = 0; i < m; i++) {
            int row = n - 1;
            if(board[row][i] == 'O') {
                dfsRecursion(board, visited, delRow, delCol, n, m, row, i);
            }
        }

    }

    public void dfsRecursion(char[][] board, int[][] visited, int[] delRow, int[] delCol, int n, int m, int row, int col) {
        visited[row][col] = 1;
        board[row][col] = 'A';

        for(int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visited[newRow][newCol] == 0 && board[newRow][newCol] == 'O') {
                dfsRecursion(board, visited, delRow, delCol, n, m, newRow, newCol);
            }
        }
    }

}