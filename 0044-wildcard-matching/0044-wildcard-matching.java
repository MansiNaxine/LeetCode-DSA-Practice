class Solution {
    public boolean isMatch(String s, String p) {
        
        int n = s.length();
        int m = p.length();

        //bruteForce Approach
        // return recursion(p, s, m - 1, n - 1);

        //MEMOIZATION
        boolean[][] dp = new boolean[m + 1][n + 1];
        // return memoRecursion(p, s, m - 1, n - 1, dp);

        //TABULATION
        return tabulation(p, s, m, n, dp);
    }

    public boolean tabulation(String s, String p, int n, int m, boolean[][] dp) {
        //base cases
        dp[0][0] = true;
        //if j == 0
        for(int i = 1; i <= n; i++) {
            boolean flag = true;
            for(int ii = 0; ii < i; ii++) {
                if(s.charAt(ii) != '*') flag = false;
            }
            dp[i][0] = flag;
        }

        //recursive cases in tabulation
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j<= m; j++) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || s.charAt(i - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (s.charAt(i - 1) == '*') dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else dp[i][j] = false;
            }
        }

        return dp[n][m];
    }

    public boolean memoRecursion(String s, String p, int i, int j, boolean[][] dp) {
        //base case
        if(i < 0 && j < 0) return true;
        if(i < 0) return false;
        if(j < 0) {
            for(int ii = 0; ii <= i; ii++) {
                if(s.charAt(ii) != '*') return false;
            }
            return true;
        }
        
        if(dp[i][j]) return dp[i][j];
        //recursive case
        if(s.charAt(i) == p.charAt(j) || s.charAt(i) == '?') return dp[i][j] = recursion(s, p, i - 1, j - 1);
        else if (s.charAt(i) == '*') return dp[i][j] = recursion(s, p, i, j - 1) || recursion(s, p, i - 1, j);
        else return dp[i][j] = false;
    }

    public boolean recursion(String s, String p, int i, int j) {
        //base case
        if(i < 0 && j < 0) return true;
        if(i < 0) return false;
        if(j < 0) {
            for(int ii = 0; ii <= i; ii++) {
                if(s.charAt(ii) != '*') return false;
            }
            return true;
        }

        //recursive case
        if(s.charAt(i) == p.charAt(j) || s.charAt(i) == '?') return recursion(s, p, i - 1, j - 1);
        else if (s.charAt(i) == '*') return  recursion(s, p, i, j - 1) || recursion(s, p, i - 1, j);
        else return false;

    }
}