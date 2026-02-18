class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int ans1 = numSubarraysWithSumAndLess(nums, goal);
        int ans2 = 0;
        if(goal - 1 < 0) return ans1;
        else ans2 = numSubarraysWithSumAndLess(nums, goal - 1);

        return ans1- ans2;
    }

    public int numSubarraysWithSumAndLess(int[] nums, int goal) {

        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;

        while(right < n) {

            sum += nums[right];

            while(sum > goal) {
                sum -= nums[left];
                left += 1;
            }

            if(sum <= goal) cnt += (right - left + 1);
            right++;
        }

        return cnt;
    }
}