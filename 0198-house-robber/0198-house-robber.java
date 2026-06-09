class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        //Solve it By Using Recursion
        //It's Giving Time Limit Exceeded
        // return recursion(nums, n - 1);

        //Solve using Memoization (1D array)
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return memoRecursion(nums, n - 1, dp);
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