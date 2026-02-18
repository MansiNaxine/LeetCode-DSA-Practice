class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]%2;
        }
        
        int ans1 = numSubarraysWithSumAndLess(nums, k);
        int ans2 = 0;
        if(k - 1 < 0) return ans1;
        else ans2 = numSubarraysWithSumAndLess(nums, k - 1);

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