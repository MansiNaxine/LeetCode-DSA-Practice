class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        //BruteForce Approach - Will exceed Time Complexity
        // return (int)recursion(grid, 0, 0, m - 1, n, m); 


        //BETTER APPROACH - MEMOIZATION
        long[][][] dp = new long[n][m][m];
        // return (int)memoRecursion(grid, 0, 0, m - 1, n, m, dp);

        //TABULATION
        //OPTIMAL APPROACH
        return (int)tabulation(grid, n, m, dp);
    }

    public long tabulation(int[][] grid, int n, int m, long[][][] dp) {
        //base case
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                if(i == j) dp[n - 1][i][j] = grid[n - 1][j];
                else dp[n - 1][i][j] = grid[n - 1][j] + grid [n - 1][i];
            }
        }

        for(int row = n - 2; row >= 0; row--) {
            for(int col1 = 0; col1 < m; col1++) {
                for(int col2 = 0; col2 < m; col2++) {
                    long max = Integer.MIN_VALUE;
                        for(int d1 = -1; d1 <= 1; d1++) {
                            for(int d2 = -1; d2 <= 1; d2++) {
                                long value = 0;
                                if(col1 == col2) value = grid[row][col1];
                                else value = grid[row][col1] + grid[row][col2];
                                int newCol1 = col1 + d1;
                                int newCol2 = col2 + d2;
                                if(newCol1 < 0 || newCol1 >= m || newCol2 < 0 || newCol2 >= m) value += Integer.MIN_VALUE;
                                else value += dp[row + 1][newCol1][newCol2];

                                max = Math.max(max, value);
                            }
                        }
                    dp[row][col1][col2] = max;
                }
            }
        }

        return dp[0][0][m - 1];
    }

    public long memoRecursion(int[][] grid, int row, int col1, int col2, int n, int m, long[][][] dp) {
        //base cases
        //boundary case
        if(col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) return Integer.MIN_VALUE;
        if(row == n - 1) {
            //check if col1 and col2 are same
            if(col1 == col2) return grid[row][col1];
            else return (grid[row][col1] + grid[row][col2]);
        }

        if(dp[row][col1][col2] != 0) return dp[row][col1][col2];
        //recursive case
        //For each robot 1 , robot 2 will traverse in 3 direction or vice-versa
        long max = Integer.MIN_VALUE;
        for(int d1 = -1; d1 <= 1; d1++) {
            for(int d2 = -1; d2 <= 1; d2++) {
                if(col1 == col2) max = Math.max(max, (grid[row][col1] + recursion(grid, row + 1, col1 + d1, col2 + d2, n , m)));
                else max = Math.max(max, (grid[row][col1] + grid[row][col2] + recursion(grid, row + 1, col1 + d1, col2 + d2, n , m)));
            }
        }

        return dp[row][col1][col2] = max;
    }

    public long recursion(int[][] grid, int row, int col1, int col2, int n, int m) {
        //base cases
        //boundary case
        if(col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) return Integer.MIN_VALUE;
        if(row == n - 1) {
            //check if col1 and col2 are same
            if(col1 == col2) return grid[row][col1];
            else return (grid[row][col1] + grid[row][col2]);
        }

        //recursive case
        //For each robot 1 , robot 2 will traverse in 3 direction or vice-versa
        long max = Integer.MIN_VALUE;
        for(int d1 = -1; d1 <= 1; d1++) {
            for(int d2 = -1; d2 <= 1; d2++) {
                if(col1 == col2) max = Math.max(max, (grid[row][col1] + recursion(grid, row + 1, col1 + d1, col2 + d2, n , m)));
                else max = Math.max(max, (grid[row][col1] + grid[row][col2] + recursion(grid, row + 1, col1 + d1, col2 + d2, n , m)));
            }
        }

        return max;
    }
}