class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();

        //BruteForce Approach
        //Recursive approach
        // return recursion(text1, text2, n - 1, m - 1);

        //Optimal Approach
        //MEMOIZATION
        int[][] dp = new int[n + 1][m + 1];
        // return memoRecursion(text1, text2, n, m, dp);

        //Most Optimal Approach
        return tabulation(text1, text2, n, m, dp);
    }

    public int tabulation(String text1, String text2, int n, int m, int[][] dp) {
        //if row == 0
        for(int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        //if col == 0
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        //recursive case
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }


    public int memoRecursion(String text1, String text2, int index1, int index2, int[][] dp) {
        //base case
        if(index1 == 0 || index2 == 0) return 0;
        
        if(dp[index1][index2] != 0) return dp[index1][index2];
        //recursive case
        if(text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) return 1 + memoRecursion(text1, text2, index1 - 1, index2 - 1, dp);

        return dp[index1][index2] = Math.max(memoRecursion(text1, text2, index1 - 1, index2, dp), memoRecursion(text1, text2, index1, index2 - 1, dp));
    }

    public int recursion(String text1, String text2, int index1, int index2) {
        //base case
        if(index1 < 0 || index2 < 0) return 0;

        //recursive case
        if(text1.charAt(index1) == text2.charAt(index2)) return 1 + recursion(text1, text2, index1 - 1, index2 - 1);

        return Math.max(recursion(text1, text2, index1 - 1, index2), recursion(text1, text2, index1, index2 - 1));
    }
}