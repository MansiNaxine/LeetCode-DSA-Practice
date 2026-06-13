class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        //bruteForce Approach - we have to reach a the bottom but index is not specified so just bottom row at any column
        //This approach will give TLE
        // return basicRecursion(triangle, 0, 0, n);

        //Better Approach - MEMOIZATION
        int[][] dp = new int[n][m];
        // return memoRecursion(triangle, 0, 0, n, dp);

        //Optimal Approach
        //TABULATION
        return tabulation(triangle, dp, n, m);
    }

    public int tabulation(List<List<Integer>> triangle, int[][] dp, int n, int m) {
        //base case

        for(int i = 0; i < m; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        //main logic
        for(int i = n - 2; i >= 0 ; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(down, diagonal);

            }
        }

        return dp[0][0];
    }

    public int memoRecursion(List<List<Integer>> triangle, int row, int col, int n, int[][] dp) {
        //base case
        if(row == n - 1) return triangle.get(row).get(col);

        //recursive case
        if(dp[row][col] != 0) return dp[row][col];

        int down = triangle.get(row).get(col) + memoRecursion(triangle, row + 1 , col, n, dp);
        int diagonal = triangle.get(row).get(col) + memoRecursion(triangle, row + 1 , col + 1, n, dp);

        return dp[row][col] = Math.min(down, diagonal);

    }

    public int basicRecursion(List<List<Integer>> triangle, int row, int col, int n) {
        //base case
        if(row == n - 1) return triangle.get(row).get(col);
        //recursive case
        int down = triangle.get(row).get(col) + basicRecursion(triangle, row + 1 , col, n);
        int diagonal = triangle.get(row).get(col) + basicRecursion(triangle, row + 1 , col + 1, n);

        return Math.min(down, diagonal);

    }
}