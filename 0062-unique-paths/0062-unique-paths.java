class Solution {
    public int uniquePaths(int m, int n) {
        
        int row = m - 1;
        int col = n - 1;

        //basic recursion
        // return basicRecursion(row, col);

        //To Avoid Time Complexity go with DP
        //Memoization -- Top down approach
        int[][] dp = new int[m][n];
        return memoRecursion(dp, row, col);
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