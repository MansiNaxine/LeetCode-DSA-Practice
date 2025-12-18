class Solution {
    public int maxSubArray(int[] nums) {

        //BruteForce Approach
        //Time Complexity :- O(n^3)
        //Space Complexity :- O(1)

        //Better Solution
        //Time Complexity :- O(n^2)
        //Space Complexity :- O(1)

        //Optimal Solution
        //Kadane's Algorithm
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            
            sum += nums[i];
            maxSum = sum > maxSum ? sum : maxSum;
            sum = sum < 0 ? 0 : sum;
        }

        return maxSum;
    }
}