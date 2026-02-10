class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int n = nums.length;
        int ans1 = findForGoal(nums, goal, n);
        int ans2 = 0;
        if(goal - 1 < 0) ans2 = 0;
        else ans2 = findForGoal(nums, goal - 1, n);

        return ans1 -  ans2;
        
    }

    public int findForGoal(int[] nums, int goal, int n) {

        int sum = 0;
        int r = 0;
        int l = 0;
        int cnt = 0;

        while(r < n) {
            sum += nums[r];

            while(sum > goal) {
                sum -= nums[l];
                l++;
            }
            
            if(sum <= goal) {
                cnt += (r - l + 1);
            }
            r++;
        }

        return cnt;
    }
}