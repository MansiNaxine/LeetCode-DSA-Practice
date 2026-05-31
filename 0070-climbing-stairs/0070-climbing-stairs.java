class Solution {
    public int climbStairs(int n) {

        //TABULATION
        int prev2 = 1;
        int prev = 1;
        for(int i = 2; i <= n ; i++) {
            int eleI = prev + prev2;
            prev2 = prev;
            prev = eleI;
        }

        return  prev;
        //MEMOIZATION
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp, -1);
    //     return helper(n, dp);
     }

    public int helper(int n, int[] dp) {
        if(n <= 1) return 1;

        if(dp[n] != -1) return dp[n];
        return dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
    }
}