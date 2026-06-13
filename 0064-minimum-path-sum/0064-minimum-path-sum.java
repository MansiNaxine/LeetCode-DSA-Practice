class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        //bruteForce Approach - will exceed time complexity
        // return (int)basicRecursion(grid, n - 1, m - 1);

        //better Solution
        //MEMOIZATION
         int[][] dp = new int[n][m];
        // return (int)memoRecursion(grid, n - 1, m - 1, dp);

        //MOST OPTIMAL SOLUTION
        //TABULATION
        // long[][] dpL = new long[n][m];
        // return tabulation(grid, dpL, n, m);

        long[] dpN = new long[m];
        return tabulationSpaceOpti(grid, dpN, n, m);
    }

    public int tabulationSpaceOpti(int[][] grid, long[] dp, int row, int col) {
        dp[0] = grid[0][0];

        for(int i = 0; i < row; i++) {
            long temp[] = new long[col];
            long min = Integer.MAX_VALUE;
            for(int j = 0; j < col; j++) {
                if(i == 0 && j == 0) temp[0] = dp[0];
                else {
                    long val1 = (long)(grid[i][j] + ((j > 0) ? temp[j - 1] : Integer.MAX_VALUE ));
                    long val2 = (i > 0) ? (long)(grid[i][j] + dp[j]) : Integer.MAX_VALUE;
                    temp[j] = Math.min(val1, val2);
                }
            }
            dp = temp;
        }

        return (int)dp[col - 1];
    }

    public int tabulation(int[][] grid, long[][] dp, int row, int col) {
        //base case
        dp[0][0] = grid[0][0];

        //expose all indexes in the form of loops
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i == 0 && j == 0) continue;
                else {
                    long up = (long)(grid[i][j] + ((i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE));
                    long left = (long)(grid[i][j] + ((j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE));

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return (int)dp[row - 1][col - 1];
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