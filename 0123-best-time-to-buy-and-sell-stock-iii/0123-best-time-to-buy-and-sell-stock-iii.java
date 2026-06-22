class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //bruteForce approach
        //recursive case
        // return recursion(prices, n, 0, 1, 2);

        int[][][] dp = new int[n + 1][2][3];
        // return memoRecursion(prices, n, 0, 1, 2, dp);

        //TABULATION
        return tabulation(prices, n, dp);
    }

    public int tabulation(int[] prices, int n, int[][][] dp) {
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j < 2; j++) {
                for(int o = 1; o < 3; o++) {
                    if(j == 1) dp[i][j][o] = Math.max((-prices[i] + dp[i + 1][0][o]) , dp[i + 1][1][o]);
                    else  dp[i][j][o] = Math.max((prices[i] + dp[i + 1][1][o - 1]) , dp[i + 1][0][o]);
                }
            }
        }

        return dp[0][1][2];
    }

    public int memoRecursion(int[] prices, int n, int index, int buy, int operation, int[][][] dp) {
        //base case
        if(index == n || operation == 0) return 0;

        if(dp[index][buy][operation] != 0) return dp[index][buy][operation];

        //recursive case
        if(buy == 1) return dp[index][buy][operation] = Math.max((-prices[index] + memoRecursion(prices, n, index + 1, 0, operation, dp)) , memoRecursion(prices, n, index + 1, 1, operation, dp));

        return dp[index][buy][operation] = Math.max((prices[index] + memoRecursion(prices, n, index + 1, 1, operation - 1, dp)) , memoRecursion(prices, n, index + 1, 0, operation, dp));
    }

    public int recursion(int[] prices, int n, int index, int buy, int operation) {
        //base case
        if(index == n || operation == 0) return 0;

        //recursive case
        if(buy == 1) return Math.max((-prices[index] + recursion(prices, n, index + 1, 0, operation)) , recursion(prices, n, index + 1, 1, operation));

        return Math.max((prices[index] + recursion(prices, n, index + 1, 1, operation - 1)) , recursion(prices, n, index + 1, 0, operation));
    }
}