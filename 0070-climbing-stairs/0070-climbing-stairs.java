class Solution {
    public int climbStairs(int n) {
        
        //Solve Using DP
        // Memoization
        // int[] ans = new int[n + 1];
        // Arrays.fill(ans, -1);
        // return dpWithMemoization(ans, n);

        //Tabulation
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[ i - 2];
        }

        return dp[n];

    }

    public int dpWithMemoization(int[] ans, int n) {
        if(n <= 1) return 1;

        if(ans[n] != -1) return ans[n];
        return ans[n] = dpWithMemoization(ans, n - 1) + dpWithMemoization(ans, n - 2);
    }
}