class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        //brteForce Approach
        // return recursion(prices, n, 0, 1);

        //MEMOIZATION
        int[][] dp = new int[n + 2][2];
        // return memoRecursion(prices, n, 0, 1, dp);

        //return tabulation(prices, n, dp);

        //more space optimization
        return spaceOptimalSolution(prices, n);
    }

    public int spaceOptimalSolution(int[] prices, int n) {
        int[] ahead1 = new int[2];
        int[] ahead2 = new int[2];

        for(int i = n - 1; i >= 0; i--) {
            int[] curr = new int[2];
            for(int j = 0; j < 2; j++) {
                if(j == 1) curr[j] = Math.max(-prices[i] + ahead1[0], ahead1[1]);
                else curr[j] = Math.max(prices[i] + ahead2[1], ahead1[0]);
            }

            ahead2 = ahead1;
            ahead1 = curr;
        }

        return ahead1[1];
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