class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        //Solve it By Using Recursion
        //It's Giving Time Limit Exceeded
        // return recursion(nums, n - 1);

        //Solve using Memoization (1D array)
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // return memoRecursion(nums, n - 1, dp);

        //TBAULATION - Space Complexity Optimization
        // return dpTabulation(nums, n, dp);

        //More optimized way with constant time complexity
        return tabulationOptimizeSpaceCom(nums, n);
    }

    public int tabulationOptimizeSpaceCom(int[] nums, int n) {
        int prev = nums[0];
        int prev1 = 0;

        for(int i = 1; i < n; i++) {
            int last = nums[i] + prev1;
            int sLast = prev;

            int currSum = Math.max(last, sLast);
            prev1 = prev;
            prev = currSum;
        }

        return prev;
    }

    public int dpTabulation(int[] nums, int n, int[] dp) {
        //base case
        dp[0] = nums[0];

        for(int i = 1; i < n; i++) {
            int last = nums[i] + ((i - 2 >= 0) ? dp[i - 2] : 0);
            int secLast = dp[i - 1];

            dp[i] = Math.max(last, secLast);

        }

        return dp[n - 1];
    }

    public int recursion(int[] nums, int n) {
        //base cases
        if(n == 0) return nums[0];
        if(n < 0) return 0;

        //Recursive case
        int last = nums[n] + recursion(nums, n - 2);
        int secLast = recursion(nums, n - 1);

        return Math.max(last, secLast);
    }

    public int memoRecursion(int[] nums, int n, int[] dp) {
        //base cases
        if(n == 0) return nums[0];
        if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];
        int last = nums[n] + memoRecursion(nums, n - 2, dp);
        int secLast = memoRecursion(nums, n - 1, dp);

        return dp[n] = Math.max(last, secLast);
    }
}