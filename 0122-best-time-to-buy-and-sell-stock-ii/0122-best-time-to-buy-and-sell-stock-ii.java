class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //recursive BruteForce approach
        // return recursion(prices, 0, 1, n);

        //MEMOIZATION
        int[][] dp = new int[n + 1][2];
        //return memoRecursion(prices, 0, 1, n, dp);

        return tabulation(prices, n, dp);
    }

    public int tabulation(int[] prices, int n, int[][] dp) {

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= 1; j++) {
                if(j == 1) dp[i][j] = Math.max((-prices[i] + dp[i + 1][0]), dp[i + 1][1]);
                else dp[i][j] = Math.max((prices[i] + dp[i + 1][1]), dp[i + 1][0]);
            }
        }

        return dp[0][1];

    }

    public int memoRecursion(int[] prices, int index, int buy, int n, int[][] dp) {
        //base case
        if(index == n) return 0;

        if(dp[index][buy] != 0) return dp[index][buy];
        //recursive case
        if(buy == 1) {
            return dp[index][buy] = Math.max((-prices[index] + recursion(prices, index + 1, 0, n)), recursion(prices, index + 1, 1, n));
        }

        return dp[index][buy] = Math.max((prices[index] + recursion(prices, index + 1, 1, n)), recursion(prices, index + 1, 0, n));
    }

    public int recursion(int[] prices, int index, int buy, int n) {
        //base case
        if(index == n) return 0;

        //recursive case
        if(buy == 1) {
            return Math.max((-prices[index] + recursion(prices, index + 1, 0, n)), recursion(prices, index + 1, 1, n));
        }

        return Math.max((prices[index] + recursion(prices, index + 1, 1, n)), recursion(prices, index + 1, 0, n));
    }
}