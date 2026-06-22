class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();

        //BruteForce Approach
        // return recursion(word1, word2, n - 1, m - 1);

        //MEMOIZATION
        int[][] dp = new int[n + 1][m + 1];
        // return memoRecusrion(word1, word2, n - 1, m - 1, dp);

        //TABULATION
        return tabulation(word1, word2, n, m, dp);
    }

    public int tabulation(String s, String t, int n, int m, int[][] dp) {
        //if j == 0
        for(int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        //if i == 0
        for(int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j]  = Math.min(1 + dp[i][j - 1] , Math.min(1 + dp[i - 1][j - 1], 1 + dp[i - 1][j]));
            }
        }

        return dp[n][m];
    }

    public int memoRecusrion(String s, String t, int i, int j, int[][] dp) {
        //base cases
        if(j < 0) return i + 1;
        if(i < 0) return j + 1;

        if(dp[i][j] != 0) return dp[i][j];
        //recursive case
        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = memoRecusrion(s, t, i - 1, j - 1, dp);

        return dp[i][j]  = Math.min(1 + memoRecusrion(s, t, i, j - 1, dp) , Math.min(1 + memoRecusrion(s, t, i - 1, j - 1, dp), 1 + memoRecusrion(s, t, i - 1, j, dp)));
    }

    public int recursion(String s, String t, int i, int j) {
        //base cases
        if(j < 0) return i + 1;
        if(i < 0) return j + 1;

        //recursive case
        if(s.charAt(i) == t.charAt(j)) return recursion(s, t, i - 1, j - 1);

        return Math.min(1 + recursion(s, t, i, j - 1) , Math.min(1 + recursion(s, t, i - 1, j - 1), 1 + recursion(s, t, i - 1, j)));
    }
}