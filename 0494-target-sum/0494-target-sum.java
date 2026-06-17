class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        int arrSize = 1001;

        int targetNew = totalSum - target;
        if(targetNew%2 == 1 || targetNew < 0) return 0;
        else targetNew  = targetNew/2;
        if(totalSum < targetNew) return 0;

        // //bruteForce Approach
        //  return recursion(nums, n - 1, targetNew);

        //MEMOIZATION
         int[][] dp = new int[n][arrSize];
        //  return meomRecursion(nums, n - 1, targetNew, dp);

        //TABULATION
        return tabulation(nums, n, targetNew, dp);
    }

    public int tabulation(int[] nums, int n, int target, int[][] dp) {
        //base cases
        if(nums[0] == 0) dp[0][0] = 2;
        else {
            dp[0][nums[0]] = 1;
            dp[0][0] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int t = 0; t <= target; t++) {
                int take = 0;
                if(nums[i] <= t) take = dp[i - 1][t - nums[i]];
                int notTake = dp[i - 1][t];

                dp[i][t] = take + notTake;
            }
        }

        return dp[n - 1][target];
    }

    public int meomRecursion(int[] nums, int index, int targetNew, int[][] dp) {
        //base cases
        if(index == 0) {
            if(nums[index] == targetNew && targetNew == 0) return 2;
            if(targetNew == 0 || nums[index] == targetNew ) return 1;
            return 0;
        }

        if(dp[index][targetNew] != 0) return dp[index][targetNew];
        //recurisve case
        int take = 0;
        if(nums[index] <= targetNew) take = recursion(nums, index - 1, targetNew - nums[index]);
        int notTake = recursion(nums, index - 1, targetNew);

        return dp[index][targetNew] = take + notTake;
    }

    public int recursion(int[] nums, int index, int targetNew) {
        //base cases
        if(index == 0) {
            if(nums[index] == targetNew && targetNew == 0) return 2;
            if(targetNew == 0 || nums[index] == targetNew ) return 1;
            return 0;
        }

        //recurisve case
        int take = 0;
        if(nums[index] <= targetNew) take = recursion(nums, index - 1, targetNew - nums[index]);
        int notTake = recursion(nums, index - 1, targetNew);

        return take + notTake;
    }
}