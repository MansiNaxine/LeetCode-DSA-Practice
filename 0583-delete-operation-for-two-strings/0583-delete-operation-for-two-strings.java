class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int totalLen = n + m;

        //bruteFroce Approach
        // int ans = recursion(word1, word2, n - 1, m - 1);
        

        //Memoization
        int[][] dp = new int[n + 1][m + 1];
        int ans = meomRecursion(word1, word2, n, m, dp);

        //tabulation
        // int ans = tabulation(word1, word2, n, m, dp);
        return totalLen - (2 * ans);
    }

    public int tabulation(String s1, String s2, int n, int m, int[][] dp) {
        //when i = 0
        for(int j = 0 ; j <= m; j++) {
            dp[0][j] = 0;
        }

        for(int i = 0 ; i <= n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j<= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }

    public int meomRecursion(String s1, String s2, int i, int j, int[][] dp) {
        //base case
        if(i == 0 || j == 0) return 0;

        if(dp[i][j] != 0) return dp[i][j];
        //recursive case
        if(s1.charAt(i - 1) == s2.charAt(j - 1)) return 1 + meomRecursion(s1, s2, i - 1, j - 1, dp);
        return dp[i][j] = Math.max(meomRecursion(s1, s2, i - 1, j, dp), meomRecursion(s1, s2, i, j - 1, dp));
    }

    public int recursion(String s1, String s2, int i, int j) {
        //base case
        if(i < 0 || j < 0) return 0;

        //recursive case
        if(s1.charAt(i) == s2.charAt(j)) return 1 + recursion(s1, s2, i - 1, j - 1);
        return Math.max(recursion(s1, s2, i - 1, j), recursion(s1, s2, i, j - 1));
    }
}