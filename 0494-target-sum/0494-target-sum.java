class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        int targetNew = totalSum - target;
        if(targetNew%2 == 1 || targetNew < 0) return 0;
        else targetNew  = targetNew/2;
        if(totalSum < targetNew) return 0;

        // //bruteForce Approach
        //  return recursion(nums, n - 1, targetNew);

        //MEMOIZATION
         int[][] dp = new int[n][totalSum + 1];
         return meomRecursion(nums, n - 1, targetNew, dp);
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