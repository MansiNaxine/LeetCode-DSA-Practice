class Solution {
    public int maxProfit(int[] prices, int fee) {
         int n = prices.length;
        //recursive BruteForce approach
        // return recursion(prices, 0, 1, n, fee);

        //MEMOIZATION
        int[][] dp = new int[n + 1][2];
        // return memoRecursion(prices, 0, 1, n, dp, fee);

        // return tabulation(prices, n, dp, fee);

        //return space Optimization
        return spaceOptimalsolution(prices, n, fee);
    }

    public int spaceOptimalsolution(int[] prices, int n, int fee) {
        int[] ahead = new int[2];

        for(int i = n - 1; i >= 0; i--) {
            int[] curr = new int[2];
            for(int j = 0; j <= 1; j++) {
                if(j == 1) curr[j] = Math.max((-prices[i] - fee + ahead[0]), ahead[1]);
                else curr[j] = Math.max((prices[i] + ahead[1]), ahead[0]);
            }

            ahead = curr;
        }

        return ahead[1];

    }

    public int tabulation(int[] prices, int n, int[][] dp, int fee) {

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= 1; j++) {
                if(j == 1) dp[i][j] = Math.max((-prices[i] - fee + dp[i + 1][0]), dp[i + 1][1]);
                else dp[i][j] = Math.max((prices[i] + dp[i + 1][1]), dp[i + 1][0]);
            }
        }

        return dp[0][1];

    }

    public int memoRecursion(int[] prices, int index, int buy, int n, int[][] dp, int fee) {
        //base case
        if(index == n) return 0;

        if(dp[index][buy] != 0) return dp[index][buy];
        //recursive case
        if(buy == 1) {
            return dp[index][buy] = Math.max((-prices[index] - fee + memoRecursion(prices, index + 1, 0, n, dp, fee)), memoRecursion(prices, index + 1, 1, n, dp, fee));
        }

        return dp[index][buy] = Math.max((prices[index] + memoRecursion(prices, index + 1, 1, n, dp, fee)), memoRecursion(prices, index + 1, 0, n, dp, fee));
    }

    public int recursion(int[] prices, int index, int buy, int n, int fee) {
        //base case
        if(index == n) return 0;

        //recursive case
        if(buy == 1) {
            return Math.max((-prices[index] - fee+ recursion(prices, index + 1, 0, n, fee)), recursion(prices, index + 1, 1, n, fee));
        }

        return Math.max((prices[index] + recursion(prices, index + 1, 1, n, fee)), recursion(prices, index + 1, 0, n, fee));
    }
}