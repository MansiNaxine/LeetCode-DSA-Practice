class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        //bruteForce Approach - will exceed time complexity
        // return (int)basicRecursion(grid, n - 1, m - 1);

        //better Solution
        //MEMOIZATION
        int[][] dp = new int[n][m];
        return (int)memoRecursion(grid, n - 1, m - 1, dp);
    }

    public long memoRecursion(int[][] grid, int row, int col, int[][] dp) {
        //base cases
        if(row == 0 && col == 0) return grid[row][col];
        if(row < 0 || col < 0) return Integer.MAX_VALUE;

        //recursive case
        if(dp[row][col] != 0) return dp[row][col];
        long up = grid[row][col] + memoRecursion(grid, row - 1, col, dp);
        long left = grid[row][col] + memoRecursion(grid, row, col - 1, dp);

        return dp[row][col] = (int)Math.min(up, left); 
    }


    public long basicRecursion(int[][] grid, int row, int col) {
        //base case
        if(row == 0 && col == 0) return grid[row][col];
        if(row < 0 || col < 0) return Integer.MAX_VALUE;

        //RECURSIVE CASE
        long up = grid[row][col] + basicRecursion(grid, row - 1, col);
        long left = grid[row][col] + basicRecursion(grid, row, col - 1);

        return Math.min(up, left);
    }
}