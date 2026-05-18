class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        defsTraversal(grid, n, m);
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    cnt += 1;
                }
            }
        }

        return cnt;
    }

    public void defsTraversal(int[][] board, int n, int m) {
        //Check all boundaries
        //Check down
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            int col = 0;
            if(board[i][col] == 1) {
                dfsRecursion(board, visited, delRow, delCol, n, m, i, col);
            }
        }

        //check right
        for(int i = 0; i < m; i++) {
            int row = 0;
            if(board[row][i] == 1) {
                dfsRecursion(board, visited, delRow, delCol, n, m, row, i);
            }
        }

        //check right column
        for(int i = 0; i < n; i++) {
            int col = m - 1;
            if(board[i][col] == 1) {
                dfsRecursion(board, visited, delRow, delCol, n, m, i, col);
            }
        }

        //check bottom right
        for(int i = 0; i < m; i++) {
            int row = n - 1;
            if(board[row][i] == 1) {
                dfsRecursion(board, visited, delRow, delCol, n, m, row, i);
            }
        }

    }

    public void dfsRecursion(int[][] board, int[][] visited, int[] delRow, int[] delCol, int n, int m, int row, int col) {
        visited[row][col] = 1;
        board[row][col] = 0;

        for(int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visited[newRow][newCol] == 0 && board[newRow][newCol] == 1) {
                dfsRecursion(board, visited, delRow, delCol, n, m, newRow, newCol);
            }
        }
    }
}