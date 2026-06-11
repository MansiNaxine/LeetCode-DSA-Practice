class Solution {
    public int uniquePaths(int m, int n) {
        
        int row = m - 1;
        int col = n - 1;

        //basic recursion
        // return basicRecursion(row, col);

        //To Avoid Time Complexity go with DP
        //Memoization -- Top down approach
        int[][] dp = new int[m][n];
        // return memoRecursion(dp, row, col);

        //Cut down to Spcae Complexity -- avoid unnecessary Recursive space
        return tabulationDP(dp, m, n);
    }

    public int tabulationDP(int[][] dp, int row, int col) {
        //base cases
        dp[0][0] = 1;

        //put all the indexes from recursion into loop
        //first loop will indicate row
        for(int i = 0; i < row; i++) {
            //second loop will indicate col
            for(int j = 0; j < col; j++) {
                if(i == 0 && j == 0) continue;
                else {
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    int left = (j > 0) ? dp[i][j - 1] : 0;

                    dp[i][j] = up + left;
                }
            }
        }

        return dp[row - 1][col - 1];
    }

    public int memoRecursion(int[][] dp, int row, int col) {
        //base cases
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;

        if(dp[row][col] != 0) return dp[row][col];

        int up = memoRecursion(dp, row - 1, col);
        int left = memoRecursion(dp, row, col - 1);

        return dp[row][col] = up + left;
    }

    public int basicRecursion(int row, int col) {
        //base case
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;

        int up = basicRecursion(row - 1, col);
        int left = basicRecursion(row, col - 1);

        return up + left;
    }
}