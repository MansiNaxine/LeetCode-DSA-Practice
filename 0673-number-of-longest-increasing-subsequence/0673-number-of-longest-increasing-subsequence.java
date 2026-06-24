class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        return modifiedTabulation(nums, nums.length);
    }

    public static int modifiedTabulation(int[] nums, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxAns = 0;
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(1 + dp[j] > dp[i] && nums[j] < nums[i]) {
                    dp[i] = 1 + dp[j];
                    cnt[i] = cnt[j];
                }
                else if(nums[j] < nums[i] && 1 + dp[j] == dp[i]){
                    cnt[i] += cnt[j];
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }

        int no = 0;
        for(int i = 0; i < n; i++) {
            if(dp[i] == maxAns) no += cnt[i];
        }
        
        return no;
    }
}