class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int n = nums.length;
        // for(int i = 0 ; i < n; i++) {
        //     nums[i] = nums[i]%2;
        // }

        int ans1 = findanswer(nums, n, k);
        int ans2 = 0;
        if(k - 1 < 0) ans2 = 0;
        ans2 = findanswer(nums, n , k - 1);

        return ans1 - ans2;
    }

    public int findanswer(int[] nums, int n, int k) {
        int sum = 0;
        int cnt = 0;
        int r = 0;
        int l = 0;

        while(r < n) {

            sum += (nums[r] % 2);

            while(sum > k) {
                sum -= (nums[l] % 2);
                l++;
            }

            if(sum <= k) {
                cnt += (r - l + 1);
            }

            r++;
        }

        return cnt;
    }
}