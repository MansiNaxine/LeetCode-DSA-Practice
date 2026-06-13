class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        //bruteForceApproach -- will give TLE
        if(obstacleGrid[n - 1][m - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        // return recursionApproach(obstacleGrid, n - 1, m - 1);

        //Next best approach will be MEMOIZATION
        int[][] dp = new int[n][m];
        // return memoRecursion(obstacleGrid, n - 1, m - 1, dp);

        //Optimal Solution - TABULATION
        // return tabulationAns(obstacleGrid, n, m,  dp);

        //In tabulation itself more space optimization
        int[] dpT = new int[m];
        return tabuMoreSpaceOpti(obstacleGrid, n, m, dpT);

    }

    public int tabuMoreSpaceOpti(int[][] obstacleGrid, int n, int m, int[] dp) {
        //base case
        dp[0] = 1;

        for(int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for(int j = 0 ; j < m; j++) {
                if(obstacleGrid[i][j] == 1) temp[j] = 0;
                else temp[j] = ((j > 0) ? temp[j - 1] : 0) + dp[j];
            }
            dp = temp;
        }

        return dp[m - 1];
    }

    public int tabulationAns(int[][] obstacleGrid, int n, int m, int[][] dp) {
        //first write down all the base cases
        dp[0][0] = 1;

        //Expose all indexes in a form of loop
        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(i == 0 && j == 0) continue;
                else {
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = (obstacleGrid[i - 1][j] == 1) ? 0 : dp[i - 1][j];
                    if(j > 0) left = (obstacleGrid[i][j - 1] == 1) ? 0 : dp[i][j - 1];

                    dp[i][j] = up + left;
                }
            }
        }

        return dp[n - 1][m - 1];
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