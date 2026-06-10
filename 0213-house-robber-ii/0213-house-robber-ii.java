class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];
        int ind1 = 0;
        int ind2 = 0;

        for(int i = 0; i < n; i++) {
            if(i != 0) {
                arr1[ind1] = nums[i];
                ind1++;
            }

            if(i != n - 1) {
                arr2[ind2] = nums[i];
                ind2++;
            }
        }
        

        // int ans1 = basicRecursion(arr1, ind1 - 1);
        // int ans2 = basicRecursion(arr2, ind2 - 1);

        int[] dp1 = new int[ind1];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[ind2];
        Arrays.fill(dp2, -1);

        int ans1 = memoization(arr1, ind1 - 1, dp1);
        int ans2 = memoization(arr2, ind2 - 1, dp2);

        return Math.max(ans1, ans2);
    }

    public int memoization(int[] nums, int index, int[] dp) {
        //base case
        if(index == 0) return nums[index];
        if(index < 0) return 0;

        //Stop Unnecessary recursion
        if(dp[index] != -1) return dp[index];
        //recursive case
        int left = nums[index] + memoization(nums, index - 2, dp);
        int right = memoization(nums, index - 1, dp);

        return dp[index] = Math.max(left, right);
    }

    //Time Limit Exceeded
    // public int basicRecursion(int[] nums, int index) {
    //     //base case
    //     if(index == 0) return nums[index];
    //     if(index < 0) return 0;

    //     //recursive case
    //     int left = nums[index] + basicRecursion(nums, index - 2);
    //     int right = basicRecursion(nums, index - 1);

    //     return Math.max(left, right);
    // }
}