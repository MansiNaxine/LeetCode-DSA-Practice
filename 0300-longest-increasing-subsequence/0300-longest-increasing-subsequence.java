class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int prevIndex = -1;
        //bruteForce Approach
        //recursion
        //return recursion(nums, n, 0, -1);

        //MEMOIZATION
        int[][] dp = new int[n][n];
        return memoRecursion(nums, n, 0, -1, dp);
    }

    public int memoRecursion(int[] nums, int n, int index, int prev, int[][] dp) {
        //base case
        if(index == n) return 0;

        if(dp[index][prev + 1] != 0) return dp[index][prev + 1];

        int take = 0;
        if(prev == -1 || nums[index] > nums[prev]) take = 1 + memoRecursion(nums, n, index + 1, index, dp);
        int notTake = memoRecursion(nums, n, index + 1, prev, dp);

        return dp[index][prev + 1] = Math.max(take, notTake);
    }

    public int recursion(int[] nums, int n, int index, int prev) {
        //base case
        if(index == n) return 0;

        int take = 0;
        if(prev == -1 || nums[index] > nums[prev]) take = 1 + recursion(nums, n, index + 1, index);
        int notTake = recursion(nums, n, index + 1, prev);

        return Math.max(take, notTake);
    }
}