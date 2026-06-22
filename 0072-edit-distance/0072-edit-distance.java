class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();

        //BruteForce Approach
        // return recursion(word1, word2, n - 1, m - 1);

        //MEMOIZATION
        int[][] dp = new int[n][m];
        return memoRecusrion(word1, word2, n - 1, m - 1, dp);
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