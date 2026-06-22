class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        //brteForce Approach
        // return recursion(prices, n, 0, 1);

        //MEMOIZATION
        int[][] dp = new int[n + 2][2];
        // return memoRecursion(prices, n, 0, 1, dp);

        return tabulation(prices, n, dp);
    }

    public int tabulation(int[] prices, int n, int[][] dp) {

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j < 2; j++) {
                if(j == 1) dp[i][j] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                else dp[i][j] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
            }
        }

        return dp[0][1];
    }

    public int memoRecursion(int[] prices, int n, int index, int buy, int[][] dp) {
        //base case
        if(index >= n) return 0;

        if(dp[index][buy] != 0) return dp[index][buy];

        //recursive case
        if(buy == 1) return  dp[index][buy] = Math.max(-prices[index] + recursion(prices, n, index + 1, 0), recursion(prices, n, index + 1, 1));

        return dp[index][buy] = Math.max(prices[index] + recursion(prices, n, index + 2, 1), recursion(prices, n, index + 1, 0));
    }

    public int recursion(int[] prices, int n, int index, int buy) {
        //base case
        if(index >= n) return 0;

        //recursive case
        if(buy == 1) return Math.max(-prices[index] + recursion(prices, n, index + 1, 0), recursion(prices, n, index + 1, 1));

        return Math.max(prices[index] + recursion(prices, n, index + 2, 1), recursion(prices, n, index + 1, 0));
    }
}