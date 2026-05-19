class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(visited[i][j] == 0 && grid[i][j] == '1') {
                    int[] delRow = {-1, 0, 1, 0};
                    int[] delCol = {0, -1, 0, 1};
                    count += 1;
                    dfsTraversal(visited, grid, i, j, n, m, delRow, delCol);
                }
            }
        }

        return count;
        
    }

    public void dfsTraversal(int[][] visited, char[][] grid, int row, int col, int n, int m, int[] delRow, int[] delCol) {
        visited[row][col] = 1;

        for(int i = 0; i < 4; i++) {
            int newR = row + delRow[i];
            int newC = col + delCol[i];
            if(newR >= 0 && newR < n && newC >= 0 && newC < m && visited[newR][newC] == 0 && grid[newR][newC] == '1') {
                dfsTraversal(visited, grid, newR, newC, n, m, delRow, delCol);
            }
        }
    }
}