class Solution {
    public boolean canPartition(int[] nums) {
        
        int n = nums.length;
        //BruteForce approach - TLE
        //First check if the total sum of all elements in array is odd or not?
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        if(totalSum%2 == 1) return false;
        int sum = totalSum/2;
        // return recursion(nums, n - 1, sum);

        //To Optimize Time Complexity - TLE
        boolean[][] dp = new boolean[n][totalSum + 1];
        // return memoRecursion(nums, n - 1, sum, dp);

        //TBAULATION
        // return tabulationSol(nums, n, sum, dp);

        //More Space optimization
        return moreSpaceOptimal(nums, n, sum, totalSum);
    }

    public boolean moreSpaceOptimal(int[] nums, int n, int target, int totalSum) {
        boolean[] prev = new boolean[totalSum + 1];
        prev[0] = true;
        prev[nums[0]] = true;

        for(int i = 1; i < n; i++) {
            boolean[] curr = new boolean[totalSum + 1];
            curr[0] = true;
            for(int t = 1; t <= target; t++) {
                boolean take = false;
                if(nums[i] <= t) take = prev[t - nums[i]];
                boolean notTake = prev[t];

                curr[t] = take || notTake;
            }
            prev = curr;
        }

        return prev[target];

    }

    public boolean tabulationSol(int[] nums, int n, int target, boolean[][] dp) {
        //base cases
        for(int i = 0 ; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for(int i = 1; i < n; i++) {
            for(int t = 1; t <= target; t++) {
                boolean take = false;
                if(nums[i] <= t) take = dp[i - 1][t - nums[i]];
                boolean notTake = dp[i - 1][t];

                dp[i][t] = take || notTake;
            }
        }

        return dp[n - 1][target];

    }

    public boolean memoRecursion(int[] nums, int index, int target, boolean[][] dp) {
        //base cases
        if(target == 0) return true;
        if(index == 0) return nums[0] == target;

        //recursive cases
        if(dp[index][target]) return true;
        else {
            boolean take = false;
            if(nums[index] <= target) take = memoRecursion(nums, index - 1, target - nums[index], dp);
            boolean notTake = memoRecursion(nums, index - 1, target, dp);

            return dp[index][target] = take || notTake;
        }
    }

    public boolean recursion(int[] nums, int index, int target) {
        //base cases
        if(target == 0) return true;
        if(index == 0) return nums[0] == target;

        //recursive case
        boolean take = false;
        if(nums[index] <= target) take = recursion(nums, index - 1, target - nums[index]);
        boolean notTake = recursion(nums, index - 1, target);

        return take || notTake;
    }
}