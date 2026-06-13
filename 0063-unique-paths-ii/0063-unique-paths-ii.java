class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        //bruteForceApproach -- will give TLE
        if(obstacleGrid[n - 1][m - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        // return recursionApproach(obstacleGrid, n - 1, m - 1);

        //Next best approach will be MEMOIZATION
        int[][] dp = new int[n][m];
        return memoRecursion(obstacleGrid, n - 1, m - 1, dp);
    }

    public int memoRecursion(int[][] obstacleGrid , int row, int col, int[][] dp) {
        //base cases
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;

        if(dp[row][col] != 0) return dp[row][col];
        int up = (row > 0 && obstacleGrid[row - 1][col] == 1) ? 0 : memoRecursion(obstacleGrid, row - 1, col, dp);
        int left = (col > 0 && obstacleGrid[row][col - 1] == 1) ? 0 : memoRecursion(obstacleGrid, row, col - 1, dp);

        return dp[row][col] = up + left;
    }

    public int recursionApproach(int[][] obstacleGrid , int row, int col) {
        //base cases
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;

        int up = (row > 0 && obstacleGrid[row - 1][col] == 1) ? 0 : recursionApproach(obstacleGrid, row - 1, col);
        int left = (col > 0 && obstacleGrid[row][col - 1] == 1) ? 0 : recursionApproach(obstacleGrid, row, col - 1);

        return up + left;
    }
 }