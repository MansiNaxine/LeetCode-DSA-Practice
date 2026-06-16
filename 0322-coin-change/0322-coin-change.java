class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        //bruteForce Approach
        // int ans =  recursion(coins, n - 1, amount);

        //MEMOIZATION
        int[][] dp = new int[n][amount + 1];
        // int ans = memoRecursion(coins, n - 1, amount, dp);

        //TABULATION
        int ans = tabulation(coins, n, amount, dp);
        return ans >= 1e9 ? -1 : ans;
    }

    public int tabulation(int[] coins, int n, int amount, int[][] dp) {
        //base case
        for(int i = 0; i <= amount; i++) {
            if(i%coins[0] == 0) dp[0][i] = i/coins[0];
            else dp[0][i] = (int)1e9;
        }

        //recursive case
        for(int i = 1; i < n; i++) {
            for(int am = 0; am <= amount; am++) {
                int take = (int)1e9;
                if(coins[i] <= am) take = 1 + dp[i][am - coins[i]];
                int notTake = dp[i - 1][am];

                dp[i][am] = Math.min(take, notTake);
            }
        }

        return dp[n - 1][amount];
    }

    public int memoRecursion(int[] coins, int index, int amount, int[][] dp) {
        //base case
        if(index == 0) {
            if(amount%coins[0] == 0) return amount/coins[0];
            return (int)1e9;
        }

        if(dp[index][amount] != 0) return dp[index][amount];
        int take = (int)1e9;
        if(coins[index] <= amount) take = 1 + recursion(coins, index, amount - coins[index]);
        int notTake = recursion(coins, index - 1, amount);

        return dp[index][amount] = Math.min(take, notTake);
    }

    public int recursion(int[] coins, int index, int amount) {
        //base case
        if(index == 0) {
            if(amount%coins[0] == 0) return amount/coins[0];
            return (int)1e9;
        }

        int take = (int)1e9;
        if(coins[index] <= amount) take = 1 + recursion(coins, index, amount - coins[index]);
        int notTake = recursion(coins, index - 1, amount);

        return Math.min(take, notTake);
    }
}