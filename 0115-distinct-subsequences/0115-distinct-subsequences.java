class Solution {
    public int numDistinct(String s, String t) {
        
        int n = s.length();
        int m = t.length();

        //bruteForceAprroach
        // return recursion(s, t, n - 1, m - 1);

        //MEMOIZATION
        int[][] dp = new int[n + 1][m + 1];
        // return memoRecursion(s, t, n - 1, m - 1, dp);

        //TABULATION
        return tabulation(s, t, n, m, dp);
    }

    public int tabulation(String s, String t, int n, int m, int[][] dp) {
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        //recursive case
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j<= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][m];
    }

    public int memoRecursion(String s, String t, int i, int j, int[][] dp) {
        //base case
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != 0) return dp[i][j];
        //recursive case
        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = memoRecursion(s, t, i - 1, j - 1, dp) + memoRecursion(s, t, i - 1, j, dp);

        return dp[i][j] = memoRecursion(s, t, i - 1, j, dp);
    }

    public int recursion(String s, String t, int i, int j) {
        //base case
        if(j < 0) return 1;
        if(i < 0) return 0;

        //recursive case
        if(s.charAt(i) == t.charAt(j)) return recursion(s, t, i - 1, j - 1) + recursion(s, t, i - 1, j);

        return recursion(s, t, i - 1, j);
    }
}