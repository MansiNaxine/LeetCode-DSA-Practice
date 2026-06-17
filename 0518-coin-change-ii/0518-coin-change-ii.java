class Solution {
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        //bruteForce Approach
        // return recursion(coins, n - 1, amount);

        int arrSize = 5001;
        //MEMOIZATION
        int[][] dp = new int[n][arrSize + 1];
        // return memoRecursion(coins, n - 1, amount, dp);

        //TABULATION
        return tabulation(coins, n, amount, dp);

        //Space Optimization solution
        // return spaceOptimization(coins, n, amount, arrSize);
    }

    // public int spaceOptimization(int[] coins, int n, int amount, int arrSize) {
    //     //base cases
    //     int[] prev = new int[arrSize + 1];
        

    //     for(int i = 1; i < n; i++) {
    //         int[] curr = new int[arrSize + 1];
    //         for(int t = 0; t <= target; t++) {
    //             int take = 0;
    //             if(coins[i] <= t) take = dp[i][t - coins[i]];
    //             int notTake = recursion(coins, i - 1, t);

    //             dp[i][t] = take + notTake;
    //         }
    //     }

    //     return dp[n - 1][target];
    // }

    public int tabulation(int[] coins, int n, int target, int[][] dp) {
        //base cases
        for(int t = 0; t <= target; t++) {
            if(t%coins[0] == 0) dp[0][t] = 1;
            else dp[0][t] = 0;
        }

        for(int i = 1; i < n; i++) {
            for(int t = 0; t <= target; t++) {
                int take = 0;
                if(coins[i] <= t) take = dp[i][t - coins[i]];
                int notTake = dp[i - 1][t];

                dp[i][t] = take + notTake;
            }
        }

        return dp[n - 1][target];
    }

    public int memoRecursion(int[] coins, int index, int target, int[][] dp) {
        //base case
        if(index == 0) {
            if(target%coins[0] == 0) return 1;
            return 0;
        }

        if(dp[index][target] != 0) return dp[index][target];

        //recursive case
        int take = 0;
        if(coins[index] <= target) take = recursion(coins, index, target - coins[index]);
        int notTake = recursion(coins, index - 1, target);

        return dp[index][target] = take + notTake;
    }

    public int recursion(int[] coins, int index, int target) {
        //base case
        if(index == 0) {
            if(target%coins[0] == 0) return 1;
            return 0;
        }

        //recursive case
        int take = 0;
        if(coins[index] <= target) take = recursion(coins, index, target - coins[index]);
        int notTake = recursion(coins, index - 1, target);

        return take + notTake;

    }
}